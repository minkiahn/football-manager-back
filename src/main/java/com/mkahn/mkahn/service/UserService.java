package com.mkahn.mkahn.service;

import com.mkahn.mkahn.constant.Constant;
import com.mkahn.mkahn.constant.EnumType;
import com.mkahn.mkahn.domain.user.User;
import com.mkahn.mkahn.domain.user.UserRepository;
import com.mkahn.mkahn.dto.UserDto;
import com.mkahn.mkahn.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    private final UserMapper userMapper;

    final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Transactional // Transactional범위까지 영속성이 적용 되어 domain을 수정하면 자동으로 데이터가 수정됨
    public UserDto save(UserDto userDto) {
        userDto.setPwd(bCryptPasswordEncoder.encode(userDto.getPwd()));
        userDto.setStatus(EnumType.UserStatus.REQUEST.getName());
        Optional<User> optUser = Optional.of(userRepository.save(userMapper.convertToEntity(userDto)));
        //String token = jwtService.createAccessToken(optUser.get().getUserId(), optUser.get().getNickName());
        //optUser.get().updateToken(token);
        return userMapper.convertToDto(optUser.orElse(null));
    }

    public Object list() {
        return userRepository.findAll();
    }

    @Transactional
    public UserDto delete(Long userId) {
        Optional<User> optUser = userRepository.findById(userId);
        if(optUser.isPresent())
            optUser.get().deleteUser();
        return userMapper.convertToDto(optUser.orElse(null));
    }

    public User update(UserDto userDto) {
        User user = userMapper.convertToEntity(userDto);
        return userRepository.save(user);
    }

    public Optional<User> get(Long userId) {
        return userRepository.findById(userId);
    }

    public boolean emailCheck(UserDto userDto) {
        return !userRepository.findByUserEmail(userMapper.convertToEntity(userDto).getUserEmail()).isPresent();
    }

    public boolean nickNameCheck(UserDto userDto) {
        return !userRepository.findByNickName(userMapper.convertToEntity(userDto).getNickName()).isPresent();
    }

    @Transactional
    public UserDto signIn(UserDto userDto) {
        Optional<User>  user = userRepository.findByUserEmail(userMapper.convertToEntity(userDto).getUserEmail());
        if(user.isPresent() && bCryptPasswordEncoder.matches(userDto.getPwd(), user.get().getPwd())){
            if(user.get().getStatus().equals(EnumType.UserStatus.NORMAL.getName())){
                String token = jwtService.createAccessToken(user.get().getUserId(), user.get().getNickName(), user.get().getTeam().getId());
                user.get().updateToken(token);
            }else{
                user.get().updateToken("");
            }
             return userMapper.convertToDto(user.get());
        }
     return null;
    }

}

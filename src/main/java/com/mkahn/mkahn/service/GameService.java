package com.mkahn.mkahn.service;

import com.mkahn.mkahn.domain.game.Game;
import com.mkahn.mkahn.domain.game.GameRepository;
import com.mkahn.mkahn.dto.GameDto;
import com.mkahn.mkahn.mapper.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public List<GameDto> list(Long teamId){
        Sort sort = Sort.by(Sort.Direction.DESC, "matchDt");
        // 검색조건에 teamId 추가
        return gameMapper.convertToDtoList(gameRepository.findAllByTeamId(teamId, sort));
    }

    public GameDto save(GameDto gameDto) {
        Game gameEntity = gameMapper.convertToEntity(gameDto);
        gameEntity.setStatus("정상");
        Game savedGame = gameRepository.save(gameEntity);
        return gameMapper.convertToDto(savedGame);
    }

    @Transactional
    public GameDto update(GameDto gameDto, Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found. id=" + gameId));

        game.setMatchDt(gameDto.getMatchDt());
        game.setTime(gameDto.getTime());
        game.setPlace(gameDto.getPlace());
        game.setType(gameDto.getType());
        game.setPlayersCountType(gameDto.getType());

        // 필요한 필드 더 있으면 여기서 세팅

        return gameMapper.convertToDto(game);
    }

    @Transactional
    public void delete(Long id){
        gameRepository.deleteById(id);
    }

}



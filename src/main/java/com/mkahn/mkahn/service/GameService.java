package com.mkahn.mkahn.service;

import com.mkahn.mkahn.config.UserContext;
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

    public List<GameDto> list(){
        Sort sort = Sort.by(Sort.Direction.DESC, "matchDt");
        // 검색조건에 teamId 추가
        return gameMapper.convertToDtoList(gameRepository.findAllByTeamId(UserContext.getUser().getTeamId(), sort));
    }

    public GameDto save(GameDto gameDto) {
        Game gameEntity = gameMapper.convertToEntity(gameDto);
        gameEntity.setStatus("정상");
        gameEntity.getTeam().setId(UserContext.getUser().getTeamId());
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
        game.setPlayersCountType(gameDto.getPlayersCountType());

        Game savedGame = gameRepository.save(game);
        return gameMapper.convertToDto(savedGame);
    }

    @Transactional
    public GameDto updateResult(GameDto gameDto, Long gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found. id=" + gameId));

        game.setTeamAScore(gameDto.getTeamAScore());
        game.setTeamBScore(gameDto.getTeamBScore());
        game.setStatus(gameDto.getStatus());

        Game savedGame = gameRepository.save(game);
        return gameMapper.convertToDto(savedGame);
    }

    @Transactional
    public void delete(Long id){
        gameRepository.deleteById(id);
    }

}



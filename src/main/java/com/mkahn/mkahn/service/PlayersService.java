package com.mkahn.mkahn.service;

import com.mkahn.mkahn.config.UserContext;
import com.mkahn.mkahn.domain.players.Players;
import com.mkahn.mkahn.domain.players.PlayersRepository;
import com.mkahn.mkahn.dto.PlayersDto;
import com.mkahn.mkahn.mapper.PlayersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayersService {

    private final PlayersRepository playersRepository;
    private final PlayersMapper playersMapper;

    /**
     * 게임 참가자 목록 조회
     */
    public List<PlayersDto> list(Long gameId) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return playersMapper.toDtoList(
                playersRepository.findAllByGameIdAndTeamId(gameId, UserContext.getUser().getTeamId(), sort)
        );
    }

    @Transactional
    public PlayersDto updateResult(PlayersDto dto, Long playerId) {
        Players players = playersRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));
        players.setGoal(dto.getGoal());
        players.setAssist(dto.getAssist());
        playersRepository.save(players);
        return dto;
    };

    /**
     * 참가자 등록 / 수정 (회원 / 용병 공통)
     */
    @Transactional
    public PlayersDto addPlayer(PlayersDto dto) {

        Long teamId = UserContext.getUser().getTeamId();
        Long userId = UserContext.getUser().getUserId();
        Players players;

        if (dto.getId() != null) {
            // 🔹 수정
            players = playersRepository.findById(dto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));

            // 팀 검증 (보안)
            if (!players.getTeam().getId().equals(teamId)) {
                throw new IllegalStateException("다른 팀의 참가자는 수정할 수 없습니다.");
            }

            if (!players.getGame().getId().equals(dto.getGameId())) {
                throw new IllegalStateException("다른 게임의 참가자는 수정할 수 없습니다.");
            }

            players.setMemberId(dto.getMemberId());
            players.setName(dto.getName());
            players.setPosition1(dto.getPosition1());
            players.setPosition2(dto.getPosition2());
            players.setTeamABType(dto.getTeamABType());
        } else {
            // 🔹 신규 등록
            dto.setTeamId(teamId);
            dto.setWriterId(userId);
            players = playersMapper.toEntity(dto);

            // 공통 필드 서버에서 세팅
            players.setStatus("정상");
        }

        Players saved = playersRepository.save(players);
        return playersMapper.toDto(saved);
    }
    /**
     * 참가자 삭제
     */
    @Transactional
    public void delete(Long playerId) {
        playersRepository.deleteById(playerId);
    }
}

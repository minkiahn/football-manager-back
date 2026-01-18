package com.mkahn.mkahn.service;

import com.mkahn.mkahn.domain.quater.Quater;
import com.mkahn.mkahn.domain.quater.QuaterRepository;
import com.mkahn.mkahn.dto.QuaterDto;
import com.mkahn.mkahn.mapper.QuaterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuaterService {

    private final QuaterRepository quaterRepository;
    private final QuaterMapper quaterMapper;

    /**
     * 게임별 쿼터 목록 조회
     */
    public List<QuaterDto> listByGame(Long gameId) {
        return quaterMapper.toDtoList(
                quaterRepository.findAllByGameId(gameId)
        );
    }

    /**
     * 쿼터 수정
     */
    @Transactional
    public QuaterDto update(Long quaterId, QuaterDto dto) {
        Quater quater = quaterRepository.findById(quaterId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 쿼터입니다."));

        quater.setStatus(dto.getStatus());
        if (dto.getStatus() == null || dto.getStatus().equals("휴식")){
            quater.setPointX(null);
            quater.setPointY(null);
        }else{
            quater.setPointX(dto.getPointX());
            quater.setPointY(dto.getPointY());
        }


        return quaterMapper.toDto(quater);
    }

    /**
     * Players 등록 시 1~4쿼터 자동 생성
     * 👉 PlayersService에서 호출
     */
    @Transactional
    public void createDefaultQuaters(Long playerId) {
        for (int i = 1; i <= 4; i++) {
            QuaterDto quaterDto = new QuaterDto();
            quaterDto.setPlayerId(playerId);
            quaterDto.setQuarterNo(i);
            quaterDto.setStatus("휴식");

            Quater quater = quaterMapper.toEntity(quaterDto);
            quaterRepository.save(quater);
        }
    }

    /**
     * Players 삭제 시 해당 쿼터 전체 삭제
     * 👉 PlayersService에서 호출
     */
    @Transactional
    public void deleteByPlayer(Long playerId) {
        quaterRepository.deleteAllByPlayersId(playerId);
    }
}

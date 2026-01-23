package com.mkahn.mkahn.service;

import com.mkahn.mkahn.config.UserContext;
import com.mkahn.mkahn.domain.place.Place;
import com.mkahn.mkahn.domain.place.PlaceRepository;
import com.mkahn.mkahn.dto.PlaceDto;
import com.mkahn.mkahn.mapper.PlaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;

    /**
     * 운동장 목록 조회
     */
    public List<PlaceDto> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return placeMapper.toDtoList(
                placeRepository.findAllByTeamId(
                        UserContext.getUser().getTeamId(),
                        sort
                )
        );
    }

    /**
     * 등록 / 수정
     */
    @Transactional
    public PlaceDto save(PlaceDto dto) {
        dto.setTeamId(UserContext.getUser().getTeamId());
        Place place;
        // 신규
        place = placeMapper.toEntity(dto);
        return placeMapper.toDto(placeRepository.save(place));
    }

    /**
     * 삭제 (실삭제)
     */
    @Transactional
    public void delete(Long id) {
        placeRepository.deleteById(id);
    }
}

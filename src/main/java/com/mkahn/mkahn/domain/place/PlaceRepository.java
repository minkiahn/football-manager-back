package com.mkahn.mkahn.domain.place;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByTeamId(Long teamId, Sort sort);
}

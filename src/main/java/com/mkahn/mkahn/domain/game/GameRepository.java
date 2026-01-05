package com.mkahn.mkahn.domain.game;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findAllByTeamId(Long teamId, Sort sort);
}

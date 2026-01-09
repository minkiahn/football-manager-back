package com.mkahn.mkahn.domain.players;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayersRepository extends JpaRepository<Players, Long> {

    List<Players> findAllByGameIdAndTeamId(Long gameId, Long teamId);
}

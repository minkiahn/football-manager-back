package com.mkahn.mkahn.domain.quater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuaterRepository extends JpaRepository<Quater, Long> {

    void deleteAllByPlayersId(Long playerId);

    @Query(
            "select q " +
            "from Quater q " +
            "join q.players p " +
            "where p.game.id = :gameId"
    )
    List<Quater> findAllByGameId(@Param("gameId") Long gameId);
}

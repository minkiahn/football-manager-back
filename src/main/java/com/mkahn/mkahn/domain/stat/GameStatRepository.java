package com.mkahn.mkahn.domain.stat;

import com.mkahn.mkahn.dto.AttackStatDto;
import com.mkahn.mkahn.dto.AttendStatDto;
import com.mkahn.mkahn.dto.PointStatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameStatRepository {

    private final EntityManager em;

    /* ================= 참석율 ================= */
    public List<AttendStatDto> attendStats(Long teamId, int year) {

        String sql =
                "SELECT " +
                        "   RANK() OVER (ORDER BY attend_ratio DESC) AS ranking, " +
                        "   name, " +
                        "   attend_game_cnt, " +
                        "   total_game_cnt, " +
                        "   attend_ratio " +
                        "FROM ( " +
                        "   SELECT " +
                        "       p.name, " +
                        "       COUNT(DISTINCT p.game_id) AS attend_game_cnt, " +
                        "       ( " +
                        "           SELECT COUNT(*) " +
                        "           FROM game g2 " +
                        "           WHERE g2.status IN ('완료') " +
                        "             AND g2.team_id = :teamId " +
                        "             AND g2.match_dt LIKE CONCAT(:year,'-%') " +
                        "       ) AS total_game_cnt, " +
                        "       ROUND( " +
                        "           COUNT(DISTINCT p.game_id) / " +
                        "           ( " +
                        "               SELECT COUNT(*) " +
                        "               FROM game g2 " +
                        "               WHERE g2.status IN ('완료') " +
                        "                 AND g2.team_id = :teamId " +
                        "                 AND g2.match_dt LIKE CONCAT(:year,'-%') " +
                        "           ) * 100, 0 " +
                        "       ) AS attend_ratio " +
                        "   FROM players p " +
                        "   JOIN game g ON g.id = p.game_id " +
                        "   WHERE p.status = '정상' " +
                        "     AND g.status IN ('완료') " +
                        "     AND g.team_id = :teamId " +
                        "     AND g.match_dt LIKE CONCAT(:year,'-%') " +
                        "     AND p.member_id IS NOT NULL " +
                        "   GROUP BY p.member_id, p.name " +
                        ") t " +
                        "ORDER BY ranking";

        return em.createNativeQuery(sql, "AttendStatMapping")
                .setParameter("teamId", teamId)
                .setParameter("year", year)
                .getResultList();
    }

    /* ================= 승점 ================= */
    public List<PointStatDto> pointStats(Long teamId, int year) {

        String sql =
                "SELECT " +
                        "   RANK() OVER (ORDER BY total_point DESC) AS ranking, " +
                        "   name, win_cnt, draw_cnt, lose_cnt, total_point " +
                        "FROM ( " +
                        "   SELECT " +
                        "       p.name, " +
                        "       SUM(CASE " +
                        "           WHEN p.teamABType='A' AND g.teamAScore > g.teamBScore THEN 1 " +
                        "           WHEN p.teamABType='B' AND g.teamBScore > g.teamAScore THEN 1 " +
                        "           ELSE 0 END) AS win_cnt, " +
                        "       SUM(CASE WHEN g.teamAScore = g.teamBScore THEN 1 ELSE 0 END) AS draw_cnt, " +
                        "       SUM(CASE " +
                        "           WHEN p.teamABType='A' AND g.teamAScore < g.teamBScore THEN 1 " +
                        "           WHEN p.teamABType='B' AND g.teamBScore < g.teamAScore THEN 1 " +
                        "           ELSE 0 END) AS lose_cnt, " +
                        "       SUM(CASE " +
                        "           WHEN p.teamABType='A' AND g.teamAScore > g.teamBScore THEN 3 " +
                        "           WHEN p.teamABType='B' AND g.teamBScore > g.teamAScore THEN 3 " +
                        "           WHEN g.teamAScore = g.teamBScore THEN 2 " +
                        "           ELSE 1 END) AS total_point " +
                        "   FROM players p " +
                        "   JOIN game g ON g.id = p.game_id " +
                        "   WHERE p.status = '정상' " +
                        "     AND g.status IN ('완료') " +
                        "     AND g.team_id = :teamId " +
                        "     AND g.match_dt LIKE CONCAT(:year,'-%') " +
                        "     AND p.member_id IS NOT NULL " +
                        "   GROUP BY p.member_id, p.name " +
                        ") t " +
                        "ORDER BY ranking";

        return em.createNativeQuery(sql, "PointStatMapping")
                .setParameter("teamId", teamId)
                .setParameter("year", year)
                .getResultList();
    }

    /* ================= 공격 ================= */
    public List<AttackStatDto> attackStats(Long teamId, int year) {

        String sql =
                "SELECT " +
                        "   RANK() OVER (ORDER BY attack_point DESC) AS ranking, " +
                        "   name, goal, assist, attack_point " +
                        "FROM ( " +
                        "   SELECT " +
                        "       p.name, " +
                        "       SUM(IFNULL(p.goal, 0)) AS goal, " +
                        "       SUM(IFNULL(p.assist, 0)) AS assist, " +
                        "       SUM(IFNULL(p.goal, 0) + IFNULL(p.assist, 0)) AS attack_point " +
                        "   FROM players p " +
                        "   JOIN game g ON g.id = p.game_id " +
                        "   WHERE p.status = '정상' " +
                        "     AND g.status IN ('완료') " +
                        "     AND g.team_id = :teamId " +
                        "     AND g.match_dt LIKE CONCAT(:year,'-%') " +
                        "     AND p.member_id IS NOT NULL " +
                        "   GROUP BY p.member_id, p.name " +
                        ") t " +
                        "ORDER BY ranking";

        return em.createNativeQuery(sql, "AttackStatMapping")
                .setParameter("teamId", teamId)
                .setParameter("year", year)
                .getResultList();
    }
}

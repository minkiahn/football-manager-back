package com.mkahn.mkahn.domain.stat;

import com.mkahn.mkahn.dto.AttackStatDto;
import com.mkahn.mkahn.dto.AttendStatDto;
import com.mkahn.mkahn.dto.PointStatDto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

/**
 * 통계 전용 SqlResultSetMapping 정의용 더미 엔티티
 * - 실제 테이블과 매핑되지 않음
 * - Native Query DTO 매핑만 담당
 */
@Entity
@SqlResultSetMappings({

        /* ================= 참석율 ================= */
        @SqlResultSetMapping(
                name = "AttendStatMapping",
                classes = @ConstructorResult(
                        targetClass = AttendStatDto.class,
                        columns = {
                                @ColumnResult(name = "ranking", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "attend_game_cnt", type = Integer.class),
                                @ColumnResult(name = "total_game_cnt", type = Integer.class),
                                @ColumnResult(name = "attend_ratio", type = Integer.class)
                        }
                )
        ),

        /* ================= 승점 ================= */
        @SqlResultSetMapping(
                name = "PointStatMapping",
                classes = @ConstructorResult(
                        targetClass = PointStatDto.class,
                        columns = {
                                @ColumnResult(name = "ranking", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "win_cnt", type = Integer.class),
                                @ColumnResult(name = "draw_cnt", type = Integer.class),
                                @ColumnResult(name = "lose_cnt", type = Integer.class),
                                @ColumnResult(name = "total_point", type = Integer.class)
                        }
                )
        ),

        /* ================= 공격 ================= */
        @SqlResultSetMapping(
                name = "AttackStatMapping",
                classes = @ConstructorResult(
                        targetClass = AttackStatDto.class,
                        columns = {
                                @ColumnResult(name = "ranking", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "goal", type = Integer.class),
                                @ColumnResult(name = "assist", type = Integer.class),
                                @ColumnResult(name = "attack_point", type = Integer.class)
                        }
                )
        )
})
public class GameStatSqlMapping {

    /**
     * JPA Entity 스캔을 위한 더미 PK
     */
    @Id
    private Long id;
}

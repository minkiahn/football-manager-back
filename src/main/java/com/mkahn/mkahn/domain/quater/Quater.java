package com.mkahn.mkahn.domain.quater;

import com.mkahn.mkahn.domain.players.Players;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
@Table(name = "quater")
public class Quater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 매치 플레이어 */
    @JoinColumn(name = "players_id", nullable = false)
    @ManyToOne
    private Players players;

    /** 쿼터 번호 (1~4) */
    @Column(nullable = false)
    private Integer quarterNo;

    /** 출전 / 휴식 / 교체 */
    @Column(nullable = false)
    private String status;

    /** 작전판 X 좌표 */
    private Integer pointX;

    /** 작전판 Y 좌표 */
    private Integer pointY;
}

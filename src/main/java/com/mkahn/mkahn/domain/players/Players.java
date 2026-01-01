package com.mkahn.mkahn.domain.players;

import com.mkahn.mkahn.domain.game.Game;
import com.mkahn.mkahn.domain.team.Team;
import com.mkahn.mkahn.domain.user.User;
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
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "teamId")
    @ManyToOne
    private Team team;

    @JoinColumn(name = "gameId")
    @ManyToOne
    private Game game;

    @Column
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position1;

    @Column
    private String position2;

    @Column(nullable = false)
    private String teamABType;

    @Column
    private Integer goal;

    @Column
    private Integer assist;

    @JoinColumn(name = "writer")
    @ManyToOne
    private User writer;

}

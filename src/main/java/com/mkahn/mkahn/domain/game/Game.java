package com.mkahn.mkahn.domain.game;

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
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "teamId")
    @ManyToOne
    private Team team;

    @Column(nullable = false)
    private String matchDt;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String playersCountType;

    @Column
    private Integer teamAScore;

    @Column
    private Integer teamBScore;

    @JoinColumn(name = "writer")
    @ManyToOne
    private User writer;

}

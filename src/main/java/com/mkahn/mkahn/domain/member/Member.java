package com.mkahn.mkahn.domain.member;

import com.mkahn.mkahn.domain.BaseTimeEntity;
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
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "teamId")
    @ManyToOne
    private Team team;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position1;

    @Column
    private String position2;

}

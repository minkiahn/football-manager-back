package com.mkahn.mkahn.domain.user;
import com.mkahn.mkahn.constant.Constant;
import com.mkahn.mkahn.constant.EnumType;
import com.mkahn.mkahn.domain.BaseTimeEntity;
import com.mkahn.mkahn.domain.team.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DynamicUpdate //수정된 칼럼만 업데이트
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @JoinColumn(name = "teamId")
    @ManyToOne
    private Team team;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String pwd;

    @Column
    private String token;

    @Column
    private String refreshToken;

    @Builder
    public User(Long userId, String userEmail, String nickName, String status, String pwd, String token, String refreshToken) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.nickName = nickName;
        this.status = status;
        this.pwd = pwd;
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public void updateToken(String token){
        this.token = token;
    }

    public void deleteUser() {
        this.status = EnumType.UserStatus.DELETE.getName();
    }
}
package com.mkahn.mkahn.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllByTeamIdAndStatus(Long teamId, String status,Sort sort );
}

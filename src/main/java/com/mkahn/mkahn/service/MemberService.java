package com.mkahn.mkahn.service;

import com.mkahn.mkahn.config.UserContext;
import com.mkahn.mkahn.domain.member.Member;
import com.mkahn.mkahn.domain.member.MemberRepository;
import com.mkahn.mkahn.dto.MemberDto;
import com.mkahn.mkahn.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    /**
     * 팀원 목록 조회
     */
    public List<MemberDto> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return memberMapper.toDtoList(
                memberRepository.findAllByTeamIdAndStatus(
                        UserContext.getUser().getTeamId(),
                        "정상",
                        sort
                )
        );
    }

    /**
     * 등록 / 수정
     */
    @Transactional
    public MemberDto save(MemberDto dto) {

        dto.setTeamId(UserContext.getUser().getTeamId());

        Member member;
        if (dto.getId() != null) {
            // 수정
            member = memberRepository.findById(dto.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Member not found"));
            member.setName(dto.getName());
            member.setPosition1(dto.getPosition1());
            member.setPosition2(dto.getPosition2());
        } else {
            // 신규
            member = memberMapper.toEntity(dto);
            member.setStatus("정상");
        }

        return memberMapper.toDto(memberRepository.save(member));
    }

    /**
     * 삭제 (소프트 삭제)
     */
    @Transactional
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}

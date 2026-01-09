package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.MemberDto;
import com.mkahn.mkahn.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public List<MemberDto> list() {
        return memberService.list();
    }

    @PostMapping
    public MemberDto save(@RequestBody MemberDto dto) {
        return memberService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.delete(id);
    }
}

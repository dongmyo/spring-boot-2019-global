package com.nhnent.edu.spring_boot.controller;

import com.nhnent.edu.spring_boot.domain.Member;
import com.nhnent.edu.spring_boot.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping("/subscribe")
    @ResponseStatus(HttpStatus.OK)
    public void subscribe(@RequestBody Member member) {
        memberService.subscribe(member);
    }

}

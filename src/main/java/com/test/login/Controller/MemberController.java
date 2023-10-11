package com.test.login.Controller;


import com.test.login.DTO.MemberDTO;
import com.test.login.Entity.Member;
import com.test.login.Service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private final MemberService memberService;



    @PostMapping("/login")
    public String login(@RequestParam("id") String id,@RequestParam("pw")String pw, HttpSession session) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setLogin_id(id);
        memberDTO.setPw(pw);
        Member member = memberService.login(memberDTO);
        if (member == null) {
            return "no";
        }
        session.setAttribute("id", id);
        session.setAttribute("name", member.getName());
        loginCheck(id, session);
        return "yes";
    }





    private String loginCheck(String id, HttpSession session) {
        session.setAttribute("id", id);

        return null;
    }
}
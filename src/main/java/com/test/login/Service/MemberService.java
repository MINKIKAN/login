package com.test.login.Service;

import com.test.login.DTO.MemberDTO;
import com.test.login.Entity.Member;
import com.test.login.Repository.MemberRepository;
import com.test.login.passwordEncoder.Sha;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    public Member login(MemberDTO memberDTO) {
        log.info("로그인 로직 실행 ");
        Member member = new Member();
        member.setLogin_id(memberDTO.getLogin_id());
        member.setPw(memberDTO.getPw());
        log.info("아이디 : " + memberDTO.getLogin_id());
        log.info("비번 : " + memberDTO.getPw());
        String hashingPw= Sha.hashWithSHA256(memberDTO.getPw());
        member.setPw(hashingPw);
        List<Member> list = memberRepository.findByLoginIdAndPw(member);

        if (list.size() == 0) {
            log.info("그런 회원 없음 ");
            return null;
        } else {
            String name = list.get(0).getName();
            member.setName(name);
            return member;
        }
    }

}

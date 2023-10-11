package com.test.login.Repository;


import com.test.login.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@Repository
@RequiredArgsConstructor
@Slf4j

public class MemberRepository {
    private final EntityManager em;

    @Transactional
    public List<Member> findByLoginIdAndPw(Member member) {
        return em.createQuery("select  m from Member m where m.login_id = :login_id and m.pw = :pw ", Member.class)
                .setParameter("login_id", member.getLogin_id())
                .setParameter("pw", member.getPw())
                .getResultList();
    }
    @Transactional
    public List<String> getNamesByLoginIdAndPw(Member member) {
        List<Member> members = findByLoginIdAndPw(member);
        List<String> names = new ArrayList<>();
        for (Member m : members) {
            names.add(m.getName());
        }
        return names;
    }
}





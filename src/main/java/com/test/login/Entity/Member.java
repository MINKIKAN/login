package com.test.login.Entity;


import com.test.login.passwordEncoder.Sha;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "member_id")
    private long id;
    private String login_id;
    private String pw;
    private String name;


}

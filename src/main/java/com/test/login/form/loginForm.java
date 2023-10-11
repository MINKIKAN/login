package com.test.login.form;

import jakarta.jms.Message;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;



@Getter
@Setter
public class loginForm {
    @NotEmpty(message = "아이디입력은 필수입니다")
       private String login_id;
       private  String pw;
}

package com.test.login.Controller;



import com.test.login.Service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@Slf4j

public class HomeController {


    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        log.info("home controller");
        return "home";
    }
    @RequestMapping("/AfterLogin")
    public String AfterLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        String name = (String)session.getAttribute("name");
        model.addAttribute("id",session);
        model.addAttribute("name", name);
        return "AfterLogin";
    }


    }




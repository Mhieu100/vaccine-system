package team.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String ui_login() {
        return "auth/login";
    }

    @GetMapping("/access-deny")
    public String access_deny() {
        return "auth/access_deny";
    }
}

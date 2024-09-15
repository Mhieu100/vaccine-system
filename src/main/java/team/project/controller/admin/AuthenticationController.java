package team.project.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String ui_login() {
        return "admin/auth/login";
    }

    @GetMapping("/access-deny")
    public String access_deny() {
        return "admin/auth/access_deny";
    }
}

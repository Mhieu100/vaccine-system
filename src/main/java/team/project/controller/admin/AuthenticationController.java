package team.project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.project.model.User;

@Controller
public class AuthenticationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String ui_login() {
        return "admin/auth/login";
    }

    @GetMapping("/access-deny")
    public String access_deny() {
        return "admin/auth/access_deny";
    }
}

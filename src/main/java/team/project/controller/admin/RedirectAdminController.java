package team.project.controller.admin;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.project.model.User;
import team.project.service.UserService;

@Controller
@RequestMapping("admin")
public class RedirectAdminController {

    private final UserService userService;
    public RedirectAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String auto() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String ui_dashboard() {
        return "admin/dashboard/index";
    }

    @GetMapping("/profile")
    public String ui_profile(HttpSession session, Model model) {
        User user = userService.getUserByEmail((String) session.getAttribute("email"));
        model.addAttribute("user", user);
        System.out.println(user);
        return "admin/dashboard/profile";
    }
}

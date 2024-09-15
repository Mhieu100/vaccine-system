package team.project.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class RedirectAdminController {

    @GetMapping("/")
    public String auto() {
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String ui_dashboard(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("user"));
        return "admin/dashboard/index";
    }

}

package team.project.controller.admin;

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
    public String ui_dashboard() {
        return "admin/dashboard/index";
    }

}

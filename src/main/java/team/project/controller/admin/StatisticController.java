package team.project.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/statistics")
public class StatisticController {

    @GetMapping("/")
    public String view_vaccine() {
        return "admin/statistic/index";
    }

}

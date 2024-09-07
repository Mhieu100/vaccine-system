package team.project.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectClientController {

    @GetMapping
	public String ui_home() {
		return "client/home";
	}

}

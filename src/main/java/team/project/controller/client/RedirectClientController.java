package team.project.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectClientController {

	@GetMapping("/")
	public String auto() {
		return "redirect:/home";
	}

    @GetMapping("/home")
	public String ui_home() {
		return "client/home";
	}

	@GetMapping("/store")
	public String ui_store() {
		return "client/store";
	}

}

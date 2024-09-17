package team.project.controller.client;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import team.project.service.PatientService;
import team.project.service.UserService;
import team.project.service.VaccineService;

@Controller
public class RedirectClientController {
	private final UserService userService;
	private final PatientService patientService;
	private final VaccineService vaccineService;
	public RedirectClientController(PatientService patientService, VaccineService vaccineService, UserService userService) {
		this.patientService = patientService;
		this.vaccineService = vaccineService;
		this.userService = userService;
	}

	@GetMapping("/")
	public String auto() {
		return "redirect:/home";
	}

    @GetMapping("/home")
	public String ui_home(Model model) {
		model.addAttribute("dsVaccine", vaccineService.findAll());
		return "client/home";
	}

	@GetMapping("/profile")
	public String ui_profile(Model model, HttpSession session) {
		model.addAttribute("patient", patientService.getPatientByUser(userService.getUserByEmail((String) session.getAttribute("email"))));
		return "client/profile";
	}

}

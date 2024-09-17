package team.project.controller.client;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import team.project.service.LocationService;
import team.project.service.PatientService;
import team.project.service.UserService;
import team.project.service.VaccineService;

@Controller
public class OrderController {
    private final VaccineService vaccineService;
    private final PatientService patientService;
    private final UserService userService;
    private final LocationService locationService;
    public OrderController(VaccineService vaccineService, PatientService patientService, UserService userService, LocationService locationService) {
        this.vaccineService = vaccineService;
        this.patientService = patientService;
        this.userService = userService;
        this.locationService = locationService;
    }

    @GetMapping("/checkout/{id}")
    public String ui_checkout(Model model, @PathVariable("id") long id, HttpSession session) {
        model.addAttribute("patient", patientService.getPatientByUser(userService.getUserByEmail((String) session.getAttribute("email"))));
        model.addAttribute("vaccine", vaccineService.findById(id).get());
        model.addAttribute("locations", locationService.findAll());
        return "client/checkout";
    }

}

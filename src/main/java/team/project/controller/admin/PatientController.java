package team.project.controller.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.project.model.Patient;
import team.project.model.User;
import team.project.service.PatientService;
import team.project.service.UserService;

@Controller
@RequestMapping("admin/patients")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String view_patient(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 50);
        Page<Patient> patients = patientService.findAll(pageable);
        model.addAttribute("listPatient", patients.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", patients.getTotalPages());
        return "admin/patient/index";
    }
}

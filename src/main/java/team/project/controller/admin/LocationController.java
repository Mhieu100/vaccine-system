package team.project.controller.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team.project.model.Doctor;
import team.project.model.Patient;
import team.project.service.DoctorService;
import team.project.service.PatientService;

@Controller
@RequestMapping("admin/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public String view_doctor(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Doctor> doctors = doctorService.findAll(pageable);
        model.addAttribute("listDoctor", doctors.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", doctors.getTotalPages());
        return "admin/doctor/index";
    }

}

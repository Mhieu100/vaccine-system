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
import team.project.model.Vaccine;
import team.project.service.DoctorService;
import team.project.service.VaccineService;

@Controller
@RequestMapping("admin/vaccines")
public class VaccineController {

    private final VaccineService vaccineService;
    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/")
    public String view_doctor(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 10);
        Page<Vaccine> vaccines = vaccineService.findAll(pageable);
        model.addAttribute("listVaccine", vaccines.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", vaccines.getTotalPages());
        return "admin/vaccine/index";
    }

}

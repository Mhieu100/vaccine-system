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
import team.project.model.Receptionist;
import team.project.service.DoctorService;
import team.project.service.ReceptionistService;

@Controller
@RequestMapping("admin/receptionists")
public class ReceptionistController {

    private final ReceptionistService receptionistService;
    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }

    @GetMapping("/")
    public String view_receptionist(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Receptionist> receptionists = receptionistService.findAll(pageable);
        model.addAttribute("listReceptionist", receptionists.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", receptionists.getTotalPages());
        return "admin/receptionist/index";
    }

}

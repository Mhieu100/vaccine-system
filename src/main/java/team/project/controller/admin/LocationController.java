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
import team.project.model.Location;
import team.project.service.DoctorService;
import team.project.service.LocationService;

@Controller
@RequestMapping("admin/locations")
public class LocationController {

    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String view_doctor(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Location> locations = locationService.findAll(pageable);
        model.addAttribute("listLocation", locations.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", locations.getTotalPages());
        return "admin/location/index";
    }

}

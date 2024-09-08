package team.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.project.model.Doctor;
import team.project.model.Location;
import team.project.repository.DoctorRepository;
import team.project.repository.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Page<Location> findAll(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

    public Optional<Location> findById(long id) {
        return locationRepository.findById(id);
    }

    public Location save(Location location) {
        return locationRepository.save(location);
    }

    public void deleteById(long id) {
        locationRepository.deleteById(id);
    }
}

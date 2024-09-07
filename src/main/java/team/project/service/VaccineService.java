package team.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.project.model.Doctor;
import team.project.model.Vaccine;
import team.project.repository.DoctorRepository;
import team.project.repository.VaccineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineService {
    private final VaccineRepository vaccineRepository;
    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }

    public Page<Vaccine> findAll(Pageable pageable) {
        return vaccineRepository.findAll(pageable);
    }

    public Optional<Vaccine> findById(long id) {
        return vaccineRepository.findById(id);
    }

    public Vaccine save(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public void deleteById(long id) {
        vaccineRepository.deleteById(id);
    }
}

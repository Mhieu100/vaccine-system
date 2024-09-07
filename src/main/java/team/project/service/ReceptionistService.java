package team.project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.project.model.Doctor;
import team.project.model.Receptionist;
import team.project.repository.DoctorRepository;
import team.project.repository.ReceptionistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionistService {
    private final ReceptionistRepository receptionistRepository;
    public ReceptionistService(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    public List<Receptionist> findAll() {
        return receptionistRepository.findAll();
    }

    public Page<Receptionist> findAll(Pageable pageable) {
        return receptionistRepository.findAll(pageable);
    }

    public Optional<Receptionist> findById(long id) {
        return receptionistRepository.findById(id);
    }

    public Receptionist save(Receptionist receptionist) {
        return receptionistRepository.save(receptionist);
    }

    public void deleteById(long id) {
        receptionistRepository.deleteById(id);
    }
}

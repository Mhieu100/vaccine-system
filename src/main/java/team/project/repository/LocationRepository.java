package team.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.project.model.Doctor;
import team.project.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Page<Location> findAll(Pageable pageable);
}

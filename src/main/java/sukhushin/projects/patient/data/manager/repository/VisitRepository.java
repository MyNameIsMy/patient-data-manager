package sukhushin.projects.patient.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sukhushin.projects.patient.data.manager.entity.Visit;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByPatientId(Integer patientId);
}

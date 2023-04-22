package sukhushin.projects.patient.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sukhushin.projects.patient.data.manager.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}

package sukhushin.projects.patient.data.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sukhushin.projects.patient.data.manager.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {


}

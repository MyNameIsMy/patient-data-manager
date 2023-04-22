package sukhushin.projects.patient.data.manager.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sukhushin.projects.patient.data.manager.dto.PatientDto;

import java.time.LocalDate;

@Entity
@Table(name="patients")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "social_security_number", nullable = false)
    private String socialSecurityNumber;

    public static Patient createNew(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.name = patientDto.name();
        patient.surname = patientDto.surname();
        patient.dateOfBirth = patientDto.dateOfBirth();
        patient.socialSecurityNumber = patientDto.socialSecurityNumber();
        return patient;
    }
}

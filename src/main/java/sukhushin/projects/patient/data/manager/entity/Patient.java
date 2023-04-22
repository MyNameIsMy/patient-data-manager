package sukhushin.projects.patient.data.manager.entity;

import jakarta.persistence.*;
import lombok.*;
import sukhushin.projects.patient.data.manager.dto.PatientDto;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="patients")
@Getter
@Setter
@EqualsAndHashCode
@ToString
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

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_id")
    private List<Visit> visits;

    public static Patient createNew(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.name = patientDto.name();
        patient.surname = patientDto.surname();
        patient.dateOfBirth = patientDto.dateOfBirth();
        patient.socialSecurityNumber = patientDto.socialSecurityNumber();
        return patient;
    }
}

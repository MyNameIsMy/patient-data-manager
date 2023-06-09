package sukhushin.projects.patient.data.manager.entity;

import jakarta.persistence.*;
import lombok.*;
import sukhushin.projects.patient.data.manager.dto.VisitDto;
import sukhushin.projects.patient.data.manager.dto.VisitUpdateDto;
import sukhushin.projects.patient.data.manager.enums.VisitReason;
import sukhushin.projects.patient.data.manager.enums.VisitType;

import java.time.LocalDateTime;

@Entity
@Table(name="visits")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Visit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO: Timezone should be configured properly
    @Column(name = "time", nullable = false)
    private LocalDateTime time;

    @Enumerated
    @Column(name = "type", nullable = false)
    private VisitType visitType;

    @Enumerated
    @Column(name = "reason", nullable = false)
    private VisitReason visitReason;

    @Column(name = "family_history")
    private String familyHistory;

    @Column(name = "patient_id", nullable = false)
    private Integer patientId;

    @Version
    private Integer version;

    public static Visit createNew(VisitDto visitDto) {
        Visit visit = new Visit();
        visit.visitReason = visitDto.visitReason();
        visit.visitType = visitDto.visitType();
        visit.time = visitDto.time();
        visit.familyHistory = visitDto.familyHistory();
        visit.patientId = visitDto.patientId();
        return visit;
    }

    public static Visit updateExisted(Visit visit, VisitUpdateDto visitDto) {
        if (visitDto.visitType() != null) {
            visit.visitType = visitDto.visitType();
        }
        if (visitDto.visitReason() != null) {
            visit.visitReason = visitDto.visitReason();
        }
        if (visitDto.time() != null) {
            visit.time = visitDto.time();
        }
        if (visitDto.familyHistory() != null) {
            visit.familyHistory = visitDto.familyHistory();
        }
        return visit;
    }
}

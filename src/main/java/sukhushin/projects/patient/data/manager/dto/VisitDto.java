package sukhushin.projects.patient.data.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import sukhushin.projects.patient.data.manager.entity.Visit;
import sukhushin.projects.patient.data.manager.enums.VisitReason;
import sukhushin.projects.patient.data.manager.enums.VisitType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record VisitDto(
        @JsonProperty(value = "id") Long id,
        //TODO: Timezone should be configured properly
        @JsonProperty(value = "time", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS") LocalDateTime time,
        @JsonProperty(value = "type", required = true) VisitType visitType,
        @JsonProperty(value = "reason", required = true) VisitReason visitReason,
        @JsonProperty(value = "family_history") String familyHistory,
        @JsonProperty(value = "patient_id", required = true) Integer patientId
) {
    public VisitDto(Visit visit) {
        this(
                visit.getId(),
                visit.getTime(),
                visit.getVisitType(),
                visit.getVisitReason(),
                visit.getFamilyHistory(),
                visit.getPatientId()
        );
    }
}

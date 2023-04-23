package sukhushin.projects.patient.data.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import sukhushin.projects.patient.data.manager.entity.Visit;
import sukhushin.projects.patient.data.manager.enums.VisitReason;
import sukhushin.projects.patient.data.manager.enums.VisitType;

import java.time.LocalDateTime;

public record VisitUpdateDto(

        //TODO: Timezone should be configured properly
        @Schema(description = "Date and time of the visit in ISO 8601 format (yyyy-MM-dd'T'HH:mm:ss.SSS)", format = "date-time")
        @JsonProperty(value = "time")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS") LocalDateTime time,
        @JsonProperty(value = "type") VisitType visitType,
        @JsonProperty(value = "reason") VisitReason visitReason,
        @JsonProperty(value = "family_history") String familyHistory
) {
    public VisitUpdateDto(Visit visit) {
        this(
                visit.getTime(),
                visit.getVisitType(),
                visit.getVisitReason(),
                visit.getFamilyHistory()
        );
    }
}
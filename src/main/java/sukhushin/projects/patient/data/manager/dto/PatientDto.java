package sukhushin.projects.patient.data.manager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import sukhushin.projects.patient.data.manager.entity.Patient;

import java.time.LocalDate;

public record PatientDto(
        @Schema(accessMode = Schema.AccessMode.READ_ONLY)
        @JsonProperty(value = "id") Integer id,
        @JsonProperty(value = "name", required = true) String name,
        @JsonProperty(value = "surname", required = true) String surname,
        @Schema(description = "Date of the birth in ISO 8601 format (yyyy-MM-dd)", format = "date")
        @JsonProperty(value = "date_of_birth", required = true)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate dateOfBirth,
        @JsonProperty(value = "social_security_number", required = true) String socialSecurityNumber
) {

    public PatientDto(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getDateOfBirth(),
                patient.getSocialSecurityNumber()
        );
    }
}

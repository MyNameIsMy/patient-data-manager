package sukhushin.projects.patient.data.manager.service;

import sukhushin.projects.patient.data.manager.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto create(PatientDto patientDto);

    List<PatientDto> fetch();
}

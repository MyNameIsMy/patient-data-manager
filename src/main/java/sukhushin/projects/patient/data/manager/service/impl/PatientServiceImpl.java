package sukhushin.projects.patient.data.manager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sukhushin.projects.patient.data.manager.dto.PatientDto;
import sukhushin.projects.patient.data.manager.entity.Patient;
import sukhushin.projects.patient.data.manager.repository.PatientRepository;
import sukhushin.projects.patient.data.manager.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public PatientDto create(PatientDto newPatientDto) {
        Patient patient = Patient.createNew(newPatientDto);

        patientRepository.save(patient);

        return new PatientDto(patient);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<PatientDto> fetch() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(PatientDto::new).toList();
    }

}

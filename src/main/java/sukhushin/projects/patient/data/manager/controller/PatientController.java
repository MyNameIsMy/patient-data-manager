package sukhushin.projects.patient.data.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sukhushin.projects.patient.data.manager.dto.PatientDto;
import sukhushin.projects.patient.data.manager.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    public PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<PatientDto> create(@RequestBody PatientDto newPatientDto) {
        PatientDto createdPatientDto = patientService.create(newPatientDto);

        return ResponseEntity.ok(createdPatientDto);
    }
}

package sukhushin.projects.patient.data.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sukhushin.projects.patient.data.manager.dto.PatientDto;
import sukhushin.projects.patient.data.manager.service.PatientService;

import java.util.List;

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

    @GetMapping("/fetch")
    public ResponseEntity<List<PatientDto>> fetch() {
        List<PatientDto> patientDtoList = patientService.fetch();

        return ResponseEntity.ok(patientDtoList);
    }
}

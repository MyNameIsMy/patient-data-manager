package sukhushin.projects.patient.data.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sukhushin.projects.patient.data.manager.dto.VisitDto;
import sukhushin.projects.patient.data.manager.dto.VisitUpdateDto;
import sukhushin.projects.patient.data.manager.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    public VisitService visitService;

    @PostMapping("/create")
    public ResponseEntity<VisitDto> create(@RequestBody VisitDto newVisitDto) {
        VisitDto createdVisitDto = visitService.create(newVisitDto);

        return ResponseEntity.ok(createdVisitDto);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<VisitDto>> fetch(@RequestParam("patient_id") Integer patientId) {
        List<VisitDto> visitDtoList = visitService.fetch(patientId);

        return ResponseEntity.ok(visitDtoList);
    }

    @PutMapping("/update")
    public ResponseEntity<VisitDto> update(@RequestParam("visit_id") Long id, @RequestBody VisitUpdateDto visitUpdateDto) {
        VisitDto updatedVisitDto = visitService.update(id, visitUpdateDto);

        return ResponseEntity.ok(updatedVisitDto);
    }
}

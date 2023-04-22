package sukhushin.projects.patient.data.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sukhushin.projects.patient.data.manager.dto.VisitDto;
import sukhushin.projects.patient.data.manager.service.VisitService;

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
}

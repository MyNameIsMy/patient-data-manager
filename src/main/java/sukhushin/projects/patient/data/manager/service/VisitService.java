package sukhushin.projects.patient.data.manager.service;

import sukhushin.projects.patient.data.manager.dto.VisitDto;

import java.util.List;

public interface VisitService {

    VisitDto create(VisitDto visitDto);

    List<VisitDto> fetch(Integer patientId);
}

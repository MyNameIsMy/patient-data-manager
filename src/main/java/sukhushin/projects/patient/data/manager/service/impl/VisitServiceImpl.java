package sukhushin.projects.patient.data.manager.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sukhushin.projects.patient.data.manager.dto.VisitDto;
import sukhushin.projects.patient.data.manager.dto.VisitUpdateDto;
import sukhushin.projects.patient.data.manager.entity.Visit;
import sukhushin.projects.patient.data.manager.repository.VisitRepository;
import sukhushin.projects.patient.data.manager.service.VisitService;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public VisitDto create(VisitDto visitDto) {
        Visit visit = Visit.createNew(visitDto);

        visitRepository.save(visit);

        return new VisitDto(visit);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<VisitDto> fetch(Integer patientId) {
        List<Visit> visitList = visitRepository.findByPatientId(patientId);

        return visitList.stream().map(VisitDto::new).toList();
    }

    //TODO: Isolation level and opt. or pes. locking should be properly configured
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public VisitDto update(Long id, VisitUpdateDto visitUpdateDto) {
        Visit existedVisit = visitRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        Visit updatedVisit = Visit.updateExisted(existedVisit, visitUpdateDto);

        return new VisitDto(updatedVisit);
    }
}

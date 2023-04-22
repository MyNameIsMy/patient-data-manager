package sukhushin.projects.patient.data.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sukhushin.projects.patient.data.manager.dto.VisitDto;
import sukhushin.projects.patient.data.manager.entity.Visit;
import sukhushin.projects.patient.data.manager.repository.VisitRepository;
import sukhushin.projects.patient.data.manager.service.VisitService;

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
}

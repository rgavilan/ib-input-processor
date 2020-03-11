package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.investigationGroup.InvestigationGroup;
import es.um.asio.inputprocessor.service.repository.InvestigationGroupRepository;
import es.um.asio.inputprocessor.service.service.InvestigationGroupService;

/**
 * {@link InvestigationGroup} service implementation.
 */
@Service
public class InvestigationGroupServiceImpl implements InvestigationGroupService {

    /**
     * {@link InvestigationGroup} repository.
     */
    @Autowired
    private InvestigationGroupRepository repository;

    /**
     * Save.
     *
     * @param investigationGroup
     *            the investigationGroup
     */
    @Override
    public void save(InvestigationGroup investigationGroup) {
        repository.insert(investigationGroup);
    }
}

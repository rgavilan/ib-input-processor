package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.gruposInvestigacion.GrupoInvestigacion;
import es.um.asio.inputprocessor.service.repository.InvestigationGroupRepository;
import es.um.asio.inputprocessor.service.service.InvestigationGroupService;

/**
 * {@link GrupoInvestigacion} service implementation.
 */
@Service
public class InvestigationGroupServiceImpl implements InvestigationGroupService {

    /**
     * {@link GrupoInvestigacion} repository.
     */
    @Autowired
    private InvestigationGroupRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public GrupoInvestigacion save(final GrupoInvestigacion investigationGroup) {
        return this.repository.save(investigationGroup);
    }
}

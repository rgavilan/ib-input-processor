package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.proyectos.OrigenProyecto;
import es.um.asio.inputprocessor.service.repository.ProjectOriginsRepository;
import es.um.asio.inputprocessor.service.service.ProjectOriginsService;

/**
 * {@link OrigenProyecto} service implementation.
 */
@Service
public class ProjectOriginsServiceImpl implements ProjectOriginsService {

    /**
     * {@link OrigenProyecto} repository.
     */
    @Autowired
    private ProjectOriginsRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public OrigenProyecto save(final OrigenProyecto projectOrigins) {
        return this.repository.save(projectOrigins);
    }
}

package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.proyectos.Proyecto;
import es.um.asio.inputprocessor.service.repository.ProjectRepository;
import es.um.asio.inputprocessor.service.service.ProjectService;

/**
 * {@link Proyecto} service implementation.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    /**
     * {@link Proyecto} repository.
     */
    @Autowired
    private ProjectRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Proyecto save(final Proyecto project) {
        return this.repository.save(project);
    }
}

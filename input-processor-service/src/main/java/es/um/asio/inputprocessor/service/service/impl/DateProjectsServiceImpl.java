package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.proyectos.FechaProyecto;
import es.um.asio.inputprocessor.service.repository.DateProjectsRepository;
import es.um.asio.inputprocessor.service.service.DateProjectsService;

/**
 * {@link FechaProyecto} service implementation.
 */
@Service
public class DateProjectsServiceImpl implements DateProjectsService {

    /**
     * {@link FechaProyecto} repository.
     */
    @Autowired
    private DateProjectsRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public FechaProyecto save(final FechaProyecto dateProjects) {
        return this.repository.save(dateProjects);
    }
}

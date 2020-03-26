package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.proyectos.JustificacionPrevistaProyecto;
import es.um.asio.domain.proyectos.Proyecto;
import es.um.asio.inputprocessor.service.repository.PlannedJustificationsProjectRepository;
import es.um.asio.inputprocessor.service.service.PlannedJustificationsProjectService;

/**
 * {@link JustificacionPrevistaProyecto} service implementation.
 */
@Service
public class PlannedJustificationsProjectServiceImpl implements PlannedJustificationsProjectService {

    /**
     * {@link JustificacionPrevistaProyecto} repository.
     */
    @Autowired
    private PlannedJustificationsProjectRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public JustificacionPrevistaProyecto save(final JustificacionPrevistaProyecto pjp) {
        return this.repository.save(pjp);
    }
}

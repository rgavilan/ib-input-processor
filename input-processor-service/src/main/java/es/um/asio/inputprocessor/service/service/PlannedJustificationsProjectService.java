package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.proyectos.JustificacionPrevistaProyecto;

/**
 * {@link JustificacionPrevistaProyecto} service.
 */
public interface PlannedJustificationsProjectService extends ServicesInterface {

    /**
     * Save a plannedJustificationsProject.
     *
     * @param plannedJustificationsProject
     *            the planned justifications project
     */
    void save(JustificacionPrevistaProyecto pjp);

}

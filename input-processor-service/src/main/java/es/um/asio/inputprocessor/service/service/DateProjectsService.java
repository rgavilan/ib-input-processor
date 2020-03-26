package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.proyectos.FechaProyecto;

/**
 * {@link FechaProyecto} service.
 */
public interface DateProjectsService extends ServicesInterface {

    /**
     * Save a date project.
     *
     * @param dateProject
     *            the dateProject
     */
    void save(FechaProyecto dateProject);

}

package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.project.FechaProyecto;

/**
 * {@link FechaProyecto} service.
 */
public interface DateProjectsService extends ServicesInterface {

    /**
     * Save a project.
     *
     * @param project
     *            the project
     */
    void save(FechaProyecto dateProject);

}

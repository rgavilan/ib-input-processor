package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.project.OrigenProyecto;

/**
 * {@link OrigenProyecto} service.
 */
public interface ProjectOriginsService extends ServicesInterface {

    /**
     * Save a project origins.
     *
     * @param project
     *            origins
     *            the project origins
     */
    void save(OrigenProyecto projectOrigins);

}

package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.project.ProjectOrigins;

/**
 * {@link ProjectOrigins} service.
 */
public interface ProjectOriginsService {

    /**
     * Save a project origins.
     *
     * @param project
     *            origins
     *            the project origins
     */
    void save(ProjectOrigins projectOrigins);

}

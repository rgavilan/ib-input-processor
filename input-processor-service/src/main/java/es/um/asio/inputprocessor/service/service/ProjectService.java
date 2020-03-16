package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.project.Project;

/**
 * {@link Project} service.
 */
public interface ProjectService extends ServicesInterface {

    /**
     * Save a project.
     *
     * @param project
     *            the project
     */
    void save(Project project);

}

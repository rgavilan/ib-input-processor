package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.project.DateProjects;

/**
 * {@link DateProjects} service.
 */
public interface DateProjectsService extends ServicesInterface {

    /**
     * Save a project.
     *
     * @param project
     *            the project
     */
    void save(DateProjects dateProject);

}

package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.project.PlannedJustificationsProject;

/**
 * {@link PlannedJustificationsProject} service.
 */
public interface PlannedJustificationsProjectService extends ServicesInterface {

    /**
     * Save a plannedJustificationsProject.
     *
     * @param plannedJustificationsProject
     *            the planned justifications project
     */
    void save(PlannedJustificationsProject pjp);

}

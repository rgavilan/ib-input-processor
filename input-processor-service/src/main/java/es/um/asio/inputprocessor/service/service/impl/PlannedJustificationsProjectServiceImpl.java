package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.project.PlannedJustificationsProject;
import es.um.asio.domain.project.Project;
import es.um.asio.inputprocessor.service.repository.PlannedJustificationsProjectRepository;
import es.um.asio.inputprocessor.service.repository.ProjectRepository;
import es.um.asio.inputprocessor.service.service.PlannedJustificationsProjectService;

/**
 * {@link Project} service implementation.
 */
@Service
public class PlannedJustificationsProjectServiceImpl implements PlannedJustificationsProjectService {

    /**
     * {@link Project} repository.
     */
    @Autowired
    private PlannedJustificationsProjectRepository repository;

    /**
     * Save.
     *
     * @param project
     *            the project
     */
    @Override
    public void save(PlannedJustificationsProject pjp) {
        repository.insert(pjp);
    }
}

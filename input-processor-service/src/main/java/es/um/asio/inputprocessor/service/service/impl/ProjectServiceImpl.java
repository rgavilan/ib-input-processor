package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.project.Project;
import es.um.asio.inputprocessor.service.repository.ProjectRepository;
import es.um.asio.inputprocessor.service.service.ProjectService;

/**
 * {@link Project} service implementation.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    /**
     * {@link Project} repository.
     */
    @Autowired
    private ProjectRepository repository;

    /**
     * Save.
     *
     * @param project
     *            the project
     */
    @Override
    public void save(Project project) {
        repository.insert(project);
    }
}

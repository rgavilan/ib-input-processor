package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.project.Proyecto;
import es.um.asio.inputprocessor.service.repository.ProjectRepository;
import es.um.asio.inputprocessor.service.service.ProjectService;

/**
 * {@link Proyecto} service implementation.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    /**
     * {@link Proyecto} repository.
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
    public void save(Proyecto project) {
        repository.insert(project);
    }

    /**
     * Save.
     *
     * @param data
     *            the project
     */
    @Override
    public void save(DataSetData data) {
        repository.insert((Proyecto) data);

    }
}

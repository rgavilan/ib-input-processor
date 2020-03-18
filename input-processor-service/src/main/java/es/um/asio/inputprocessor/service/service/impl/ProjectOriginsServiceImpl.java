package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.project.OrigenProyecto;
import es.um.asio.inputprocessor.service.repository.ProjectOriginsRepository;
import es.um.asio.inputprocessor.service.service.ProjectOriginsService;

/**
 * {@link OrigenProyecto} service implementation.
 */
@Service
public class ProjectOriginsServiceImpl implements ProjectOriginsService {

    /**
     * {@link OrigenProyecto} repository.
     */
    @Autowired
    private ProjectOriginsRepository repository;

    /**
     * Save.
     *
     * @param project
     *            the project origins
     */
    @Override
    public void save(OrigenProyecto projectOrigins) {
        repository.insert(projectOrigins);
    }

    /**
     * Save.
     *
     * @param data
     *            the project origins
     */
    @Override
    public void save(DataSetData data) {
        repository.insert((OrigenProyecto) data);

    }
}

package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.proyectos.FechaProyecto;
import es.um.asio.inputprocessor.service.repository.DateProjectsRepository;
import es.um.asio.inputprocessor.service.service.DateProjectsService;

/**
 * {@link FechaProyecto} service implementation.
 */
@Service
public class DateProjectsServiceImpl implements DateProjectsService {

    /**
     * {@link FechaProyecto} repository.
     */
    @Autowired
    private DateProjectsRepository repository;

    /**
     * Save.
     *
     * @param dateProjects
     *            the dateProjects
     */
    @Override
    public void save(FechaProyecto dateProjects) {
        repository.insert(dateProjects);
    }

    /**
     * Save.
     *
     * @param data
     *            the dateProjects
     */
    @Override
    public void save(DataSetData data) {
        repository.insert((FechaProyecto) data);

    }

}

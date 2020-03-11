package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.project.DateProjects;
import es.um.asio.inputprocessor.service.repository.DateProjectsRepository;
import es.um.asio.inputprocessor.service.service.DateProjectsService;

/**
 * {@link DateProjects} service implementation.
 */
@Service
public class DateProjectsServiceImpl implements DateProjectsService {

    /**
     * {@link DateProjects} repository.
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
    public void save(DateProjects dateProjects) {
        repository.insert(dateProjects);
    }
}

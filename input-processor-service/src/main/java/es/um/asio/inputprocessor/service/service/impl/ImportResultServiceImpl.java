package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.repository.ImportResultRepository;
import es.um.asio.inputprocessor.service.service.ImportResultService;

/**
 * {@link ImportResult} service implementation.
 */
@Service
public class ImportResultServiceImpl implements ImportResultService {

    /**
     * {@link ImportResult} repository.
     */
    @Autowired
    private ImportResultRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportResult save(final ImportResult importResult) {
        return this.repository.save(importResult);
    }

}

package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.ImportResult.ImportResult;
import es.um.asio.inputprocessor.service.repository.ImportResultRepository;
import es.um.asio.inputprocessor.service.service.ImportResultService;

/**
 * {@link ImportResult} service implementation.
 */
@Service
public class ImportResultServiceImpl implements ImportResultService{

    /**
     * {@link ImportResult} repository.
     */
    @Autowired
    private ImportResultRepository repository;

    /**
     * Save.
     *
     * @param data
     *            the importResult
     */
    @Override
    public void save(DataSetData data) {
        repository.insert((ImportResult)data);        
    }

    /**
     * Save.
     *
     * @param data
     *            the importResult
     */
    @Override
    public void save(ImportResult importResult) {
        repository.insert(importResult);        
    }

}

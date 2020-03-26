package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.DataSetDataBase;
import es.um.asio.inputprocessor.service.repository.generic.DatasetGenericRepository;
import es.um.asio.inputprocessor.service.service.DatasetGenericService;


/**
 * Generic dataset service implementation.
 */
@Service
public class DatasetGenericServiceImpl implements DatasetGenericService {
    
    /**
     * Dataset generic repository.
     */
    @Autowired
    private DatasetGenericRepository datasetGenericRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public DataSetDataBase save(DataSetDataBase data) {
        return datasetGenericRepository.save(data);
    }

}

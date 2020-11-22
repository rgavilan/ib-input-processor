package es.um.asio.inputprocessor.service.proxy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.abstractions.dto.ImportResultDto;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.filter.ImportResultFilter;
import es.um.asio.inputprocessor.service.mapper.ImportResultMapper;
import es.um.asio.inputprocessor.service.proxy.ImportResultProxy;
import es.um.asio.inputprocessor.service.service.ImportResultService;

/**
 * Proxy service implementation for {@link ImportResult}. Performs DTO conversions.
 */
@Service
public class ImportResultProxyImpl implements ImportResultProxy {

    /**
     * Service Layer.
     */
    @Autowired
    private ImportResultService service;
    
    /**
     * DTO to entity mapper.
     */
    @Autowired
    private ImportResultMapper mapper;

	 
    /**
     * {@inheritDoc}
     */
    @Override
    public Page<ImportResultDto> findPaginated(ImportResultFilter filter, Pageable pageable) {
        return this.mapper.convertToDto(this.service.findPaginated(filter, pageable));
    }
}

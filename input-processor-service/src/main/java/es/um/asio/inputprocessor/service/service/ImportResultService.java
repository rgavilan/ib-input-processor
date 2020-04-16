package es.um.asio.inputprocessor.service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.filter.ImportResultFilter;

/**
 * {@link ImportResult} service.
 */
public interface ImportResultService extends DatasetService<ImportResult> {

    
    /**
     * Find paginated.
     *
     * @param filter the filter
     * @param pageable the pageable
     * @return the page
     */
    public Page<ImportResult> findPaginated(final ImportResultFilter filter, final Pageable pageable);
}
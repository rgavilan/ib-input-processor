package es.um.asio.inputprocessor.service.proxy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.abstractions.dto.ImportResultDto;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.filter.ImportResultFilter;

/**
 * Proxy service for {@link ImportResult}. Performs DTO conversion.
 */
public interface ImportResultProxy {

    /**
     * Find a paginated list of entities from a given filter.
     *
     * @param filter
     *            The filter
     * @param pageable
     *            Pagination configuration
     * @return The paginated list
     */
    Page<ImportResultDto> findPaginated(ImportResultFilter filter, Pageable pageable);
}

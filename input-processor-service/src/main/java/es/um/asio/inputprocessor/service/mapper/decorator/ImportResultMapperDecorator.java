package es.um.asio.inputprocessor.service.mapper.decorator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.izertis.abstractions.search.PageImplHelper;

import es.um.asio.abstractions.dto.ImportResultDto;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.mapper.ImportResultMapper;

/**
 * MapStruct Mapper decorator for {@link ImportResult}.
 */
public abstract class ImportResultMapperDecorator implements ImportResultMapper {

    /**
     * Delegate {@link ImportResult} mapper.
     */
    @Autowired
    @Qualifier("delegate")
    private ImportResultMapper delegate;

    /**
     * {@inheritDoc}
     */
    @Override
    public PageImplHelper<ImportResultDto> convertToDto(final Page<ImportResult> page) {
        if (page == null) {
            return null;
        }

        return new PageImplHelper<>(this.delegate.convertToDto(page.getContent()),
                PageRequest.of(page.getNumber(), page.getSize(), page.getSort()), page.getTotalElements());
    }

}

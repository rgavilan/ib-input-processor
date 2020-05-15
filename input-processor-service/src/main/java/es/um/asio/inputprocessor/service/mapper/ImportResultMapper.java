package es.um.asio.inputprocessor.service.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.izertis.abstractions.search.PageImplHelper;

import es.um.asio.abstractions.dto.ImportResultDto;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.mapper.decorator.ImportResultMapperDecorator;
import org.mapstruct.Mapping;

/**
 * MapStruct Mapper for {@link ImportResult}.
 */
@Mapper
@DecoratedWith(ImportResultMapperDecorator.class)
public interface ImportResultMapper extends BaseMapper<ImportResult, ImportResultDto> {

    /**
     * Convert entity to DTO.
     *
     * @param entity
     *            the entity
     * @return the DTO
     */
    @Override
    ImportResultDto convertToDto(ImportResult entity);

    /**
     * Convert entity list to DTO.
     *
     * @param entities
     *            the list of entitites
     * @return the list
     */
    List<ImportResultDto> convertToDto(List<ImportResult> entities);

    /**
     * Convert entity page to DTO.
     *
     * @param page
     *            entity pge.
     * @return DTO page
     */
    PageImplHelper<ImportResultDto> convertToDto(Page<ImportResult> page);

    /**
     * Convert DTO to entity.
     *
     * @param dto
     *            the DTO
     * @return the entity.
     */
    @InheritInverseConfiguration
    @Override
    ImportResult convertFromDto(ImportResultDto dto);

    /**
     * Convert DTO list to entity.
     *
     * @param entities
     *            the list of DTOs
     * @return the list
     */
    Iterable<ImportResult> convertFromDto(Iterable<ImportResultDto> dto);

    /**
     * Update entity from DTO.
     *
     * @param dto
     *            the DTO
     * @param entity
     *            the entity
     * @return the entity
     */  
    ImportResult updateFromDto(ImportResultDto dto, @MappingTarget ImportResult entity);
}

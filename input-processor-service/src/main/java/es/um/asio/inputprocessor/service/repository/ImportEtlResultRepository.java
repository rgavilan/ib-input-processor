package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import es.um.asio.domain.importetlresult.ImportEtlResult;

/**
 * {@link ImportEtlResultRepository} repository.
 */
public interface ImportEtlResultRepository
		extends JpaRepository<ImportEtlResult, String>, JpaSpecificationExecutor<ImportEtlResult> {

}

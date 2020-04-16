package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import es.um.asio.domain.importResult.ImportResult;

/**
 * {@link ImportResult} repository.
 */
public interface ImportResultRepository extends JpaRepository<ImportResult, String>, JpaSpecificationExecutor<ImportResult>  {
    
    
}

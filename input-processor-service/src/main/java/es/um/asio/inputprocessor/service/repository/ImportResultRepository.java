package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.ImportResult.ImportResult;

/**
 * {@link ImportResult} repository.
 */
public interface ImportResultRepository extends MongoRepository<ImportResult, String> {

}

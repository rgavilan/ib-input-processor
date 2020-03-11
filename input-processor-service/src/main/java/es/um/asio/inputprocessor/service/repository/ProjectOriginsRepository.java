package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.project.ProjectOrigins;

/**
 * {@link Project} repository.
 */
public interface ProjectOriginsRepository extends MongoRepository<ProjectOrigins, String> {

}

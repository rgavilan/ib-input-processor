package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.project.Project;

/**
 * {@link Project} repository.
 */
public interface ProjectRepository extends MongoRepository<Project, String> {

}

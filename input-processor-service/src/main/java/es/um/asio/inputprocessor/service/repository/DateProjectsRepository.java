package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.project.DateProjects;

/**
 * {@link Project} repository.
 */
public interface DateProjectsRepository extends MongoRepository<DateProjects, String> {

}

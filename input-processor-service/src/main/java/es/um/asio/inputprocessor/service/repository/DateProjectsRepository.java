package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.project.FechaProyecto;

/**
 * {@link Proyecto} repository.
 */
public interface DateProjectsRepository extends MongoRepository<FechaProyecto, String> {

}

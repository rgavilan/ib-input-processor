package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.proyectos.FechaProyecto;

/**
 * {@link FechaProyecto} repository.
 */
public interface DateProjectsRepository extends MongoRepository<FechaProyecto, String> {

}

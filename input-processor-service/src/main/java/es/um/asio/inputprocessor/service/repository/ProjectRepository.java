package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.proyectos.Proyecto;

/**
 * {@link Proyecto} repository.
 */
public interface ProjectRepository extends MongoRepository<Proyecto, String> {

}

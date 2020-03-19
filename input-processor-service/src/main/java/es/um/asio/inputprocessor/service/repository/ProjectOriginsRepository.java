package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.proyectos.OrigenProyecto;

/**
 * {@link Proyecto} repository.
 */
public interface ProjectOriginsRepository extends MongoRepository<OrigenProyecto, String> {

}

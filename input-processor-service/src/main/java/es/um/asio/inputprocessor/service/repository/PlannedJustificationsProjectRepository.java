package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.project.JustificacionPrevistaProyecto;
import es.um.asio.domain.project.Proyecto;

/**
 * {@link Proyecto} repository.
 */
public interface PlannedJustificationsProjectRepository extends MongoRepository<JustificacionPrevistaProyecto, String> {

}

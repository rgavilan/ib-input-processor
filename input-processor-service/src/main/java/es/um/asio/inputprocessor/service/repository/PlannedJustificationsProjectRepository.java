package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.proyectos.JustificacionPrevistaProyecto;
import es.um.asio.domain.proyectos.Proyecto;

/**
 * {@link JustificacionPrevistaProyecto} repository.
 */
public interface PlannedJustificationsProjectRepository extends JpaRepository<JustificacionPrevistaProyecto, String> {

}

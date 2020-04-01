package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.proyectos.JustificacionPrevistaProyecto;

/**
 * {@link JustificacionPrevistaProyecto} repository.
 */
public interface PlannedJustificationsProjectRepository extends JpaRepository<JustificacionPrevistaProyecto, String> {

}

package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.proyectos.OrigenProyecto;

/**
 * {@link OrigenProyecto} repository.
 */
public interface ProjectOriginsRepository extends JpaRepository<OrigenProyecto, String> {

}

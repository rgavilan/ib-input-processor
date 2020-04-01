package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.proyectos.Proyecto;

/**
 * {@link Proyecto} repository.
 */
public interface ProjectRepository extends JpaRepository<Proyecto, String> {

}

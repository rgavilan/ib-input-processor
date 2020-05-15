package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.proyectos.FechaProyecto;

/**
 * {@link FechaProyecto} repository.
 */
public interface DateProjectsRepository extends JpaRepository<FechaProyecto, String> {

}

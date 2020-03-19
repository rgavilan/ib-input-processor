package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.proyectos.Proyecto;

/**
 * {@link Proyecto} service.
 */
public interface ProjectService extends ServicesInterface {

    /**
     * Save a project.
     *
     * @param project
     *            the project
     */
    void save(Proyecto project);

}

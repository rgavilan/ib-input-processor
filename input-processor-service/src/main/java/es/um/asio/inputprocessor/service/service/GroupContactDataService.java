package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.investigationCenter.DatosContactoGrupo;

/**
 * {@link DatosContactoGrupo} service.
 */
public interface GroupContactDataService extends ServicesInterface {

    /**
     * Save a group contact data.
     *
     * @param groupContactData
     *            the group contact data
     */
    void save(DatosContactoGrupo groupContactData);

}

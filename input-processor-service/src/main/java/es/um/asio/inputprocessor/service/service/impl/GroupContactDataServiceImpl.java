package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.gruposInvestigacion.DatosContactoGrupo;
import es.um.asio.inputprocessor.service.repository.GroupContactDataRepository;
import es.um.asio.inputprocessor.service.service.GroupContactDataService;

/**
 * {@link DatosContactoGrupo} service implementation.
 */
@Service
public class GroupContactDataServiceImpl implements GroupContactDataService {

    /**
     * {@link DatosContactoGrupo} repository.
     */
    @Autowired
    private GroupContactDataRepository repository;

    /**
     * Save.
     *
     * @param groupContactData
     *            the group contact data
     */
    @Override
    public void save(DatosContactoGrupo groupContactData) {
        repository.insert(groupContactData);
    }

    /**
     * Save.
     *
     * @param data
     *            the group contact data
     */
    @Override
    public void save(DataSetData data) {
        repository.insert((DatosContactoGrupo) data);

    }
}

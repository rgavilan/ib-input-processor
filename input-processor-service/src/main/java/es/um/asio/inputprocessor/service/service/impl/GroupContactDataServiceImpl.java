package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * {@inheritDoc}
     */
    @Override
    public DatosContactoGrupo save(final DatosContactoGrupo groupContactData) {
        return this.repository.save(groupContactData);
    }
}

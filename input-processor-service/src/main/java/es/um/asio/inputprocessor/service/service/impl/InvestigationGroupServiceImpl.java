package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.gruposInvestigacion.GrupoInvestigacion;
import es.um.asio.inputprocessor.service.repository.InvestigationGroupRepository;
import es.um.asio.inputprocessor.service.service.InvestigationGroupService;

/**
 * {@link GrupoInvestigacion} service implementation.
 */
@Service
public class InvestigationGroupServiceImpl implements InvestigationGroupService {

    /**
     * {@link GrupoInvestigacion} repository.
     */
    @Autowired
    private InvestigationGroupRepository repository;

    /**
     * Save.
     *
     * @param investigationGroup
     *            the investigationGroup
     */
    @Override
    public void save(GrupoInvestigacion investigationGroup) {
        repository.insert(investigationGroup);
    }

    /**
     * Save.
     *
     * @param data
     *            the investigationGroup
     */
    @Override
    public void save(DataSetData data) {
        repository.insert((GrupoInvestigacion) data);

    }
}

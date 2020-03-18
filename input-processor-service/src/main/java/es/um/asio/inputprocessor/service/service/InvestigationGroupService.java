package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.investigationGroup.GrupoInvestigacion;

/**
 * {@link GrupoInvestigacion} service.
 */
public interface InvestigationGroupService extends ServicesInterface {

    /**
     * Save a investigationGroup.
     *
     * @param investigationGroup
     *            the investigation group
     */
    void save(GrupoInvestigacion investigationGroup);

}

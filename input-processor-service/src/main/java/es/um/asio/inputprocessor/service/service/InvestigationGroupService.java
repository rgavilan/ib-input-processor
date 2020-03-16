package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.investigationGroup.InvestigationGroup;

/**
 * {@link InvestigationGroup} service.
 */
public interface InvestigationGroupService extends ServicesInterface {

    /**
     * Save a investigationGroup.
     *
     * @param investigationGroup
     *            the investigation group
     */
    void save(InvestigationGroup investigationGroup);

}

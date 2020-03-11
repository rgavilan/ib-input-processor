package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.investigationCenter.GroupContactData;
import es.um.asio.inputprocessor.service.repository.GroupContactDataRepository;
import es.um.asio.inputprocessor.service.service.GroupContactDataService;

/**
 * {@link GroupContactData} service implementation.
 */
@Service
public class GroupContactDataServiceImpl implements GroupContactDataService {

    /**
     * {@link GroupContactData} repository.
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
    public void save(GroupContactData groupContactData) {
        repository.insert(groupContactData);
    }
}

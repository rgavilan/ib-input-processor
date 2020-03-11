package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.investigationCenter.GroupContactData;

/**
 * {@link GroupContactData} repository.
 */
public interface GroupContactDataRepository extends MongoRepository<GroupContactData, String> {

}

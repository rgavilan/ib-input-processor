package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.investigationGroup.InvestigationGroup;

/**
 * {@link InvestigationGroup} repository.
 */
public interface InvestigationGroupRepository extends MongoRepository<InvestigationGroup, String> {

}

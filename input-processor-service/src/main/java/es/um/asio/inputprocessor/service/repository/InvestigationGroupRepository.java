package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.gruposInvestigacion.GrupoInvestigacion;

/**
 * {@link GrupoInvestigacion} repository.
 */
public interface InvestigationGroupRepository extends MongoRepository<GrupoInvestigacion, String> {

}

package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.um.asio.domain.investigationCenter.DatosContactoGrupo;

/**
 * {@link DatosContactoGrupo} repository.
 */
public interface GroupContactDataRepository extends MongoRepository<DatosContactoGrupo, String> {

}

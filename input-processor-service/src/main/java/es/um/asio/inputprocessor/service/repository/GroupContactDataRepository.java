package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.gruposInvestigacion.DatosContactoGrupo;

/**
 * {@link DatosContactoGrupo} repository.
 */
public interface GroupContactDataRepository extends JpaRepository<DatosContactoGrupo, String> {

}

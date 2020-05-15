package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.gruposInvestigacion.GrupoInvestigacion;

/**
 * {@link GrupoInvestigacion} repository.
 */
public interface InvestigationGroupRepository extends JpaRepository<GrupoInvestigacion, String> {

}

package es.um.asio.inputprocessor.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.cvn.CvnRootBean;

/**
 * {@link CvnRootBean} repository.
 */
public interface CvnRootBeanRepository extends JpaRepository<CvnRootBean, String> {

}

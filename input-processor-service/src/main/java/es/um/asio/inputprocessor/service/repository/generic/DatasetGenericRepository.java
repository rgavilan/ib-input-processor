package es.um.asio.inputprocessor.service.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;

import es.um.asio.domain.DataSetDataBase;

/**
 * Dataset generic repository.
 */
public interface DatasetGenericRepository extends JpaRepository<DataSetDataBase, String> {

}

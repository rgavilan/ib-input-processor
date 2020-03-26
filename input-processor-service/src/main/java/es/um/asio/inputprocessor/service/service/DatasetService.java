package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.DataSetDataBase;

/**
 * The Interface ServicesInterface.
 */
public interface DatasetService<T extends DataSetDataBase> {

    /**
     * Save a dataset.
     *
     * @param data
     *            the dataset
     */
    T save(T data);
}

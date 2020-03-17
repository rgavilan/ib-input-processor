package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.ImportResult.ImportResult;

/**
 * {@link ImportResult} service.
 */
public interface ImportResultService extends ServicesInterface {

    /**
     * Save a import result data.
     *
     * @param groupContactData
     *            the import result data
     */
    void save(ImportResult importResult);

}
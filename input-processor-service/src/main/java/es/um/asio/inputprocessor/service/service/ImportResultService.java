package es.um.asio.inputprocessor.service.service;

import es.um.asio.domain.importResult.ImportResult;

/**
 * {@link ImportResult} service.
 */
public interface ImportResultService extends ServicesInterface {

    /**
     * Save a import result data.
     *
     * @param importResult
     *            the import result data
     */
    void save(ImportResult importResult);

}
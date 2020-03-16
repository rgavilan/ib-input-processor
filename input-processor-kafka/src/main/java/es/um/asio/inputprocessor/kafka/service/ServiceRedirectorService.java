package es.um.asio.inputprocessor.kafka.service;

import es.um.asio.domain.DataSetData;
import es.um.asio.inputprocessor.service.service.ServicesInterface;

/**
 * Service to handle message entity related operations
 */
public interface ServiceRedirectorService {
    /**
     * Process a message
     *
     * @param message
     *            The message
     * @return
     */
    ServicesInterface redirect(DataSetData data);
}

package es.um.asio.inputprocessor.kafka.service;

import es.um.asio.domain.DataSetData;
import es.um.asio.inputprocessor.service.service.ServicesInterface;

 
/**
 * Service interface to selecting {@link ServicesInterface}
 */
public interface ServiceRedirectorService {
   
    /**
     * Gets a {@link ServicesInterface} based on {@link DataSetData} type.
     *
     * @param data the data
     * @return the services interface
     */
    ServicesInterface redirect(DataSetData data);
}

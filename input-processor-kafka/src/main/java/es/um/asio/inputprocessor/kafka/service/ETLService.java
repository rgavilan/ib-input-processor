package es.um.asio.inputprocessor.kafka.service;

import es.um.asio.inputprocessor.kafka.model.ETLJobResponse;

/**
 * Service interface that run job of ETL.
 */
public interface ETLService {
    
    /**
     * Run ETL job.
     *
     * @return the ETL job response
     */
    ETLJobResponse run();
}

package es.um.asio.inputprocessor.kafka.service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.InputData;

/**
 * The Interface KafkaService.
 */
public interface KafkaService {
	
	/**
	 * Send general data topic.
	 *
	 * @param data the data
	 */
	void sendGeneralDataTopic(InputData<DataSetData> data);
}

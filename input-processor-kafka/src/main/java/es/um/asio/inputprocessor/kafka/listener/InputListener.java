package es.um.asio.inputprocessor.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.InputData;
import es.um.asio.inputprocessor.kafka.service.MessageService;

/**
 * Input message listener
 */
@Component
public class InputListener {
    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(InputListener.class);

    @Autowired
    private MessageService messageService;

    /**
     * Method listening input topic name
     * 
     * @param message
     */
    @KafkaListener(topics = "input-data", containerFactory = "inputKafkaListenerContainerFactory")
    public void listen(final InputData<DataSetData> data) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", data);
        }
    }
}

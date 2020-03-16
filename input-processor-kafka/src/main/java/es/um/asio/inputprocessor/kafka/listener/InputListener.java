package es.um.asio.inputprocessor.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.InputData;
import es.um.asio.inputprocessor.kafka.service.ServiceRedirectorService;
import es.um.asio.inputprocessor.service.service.ServicesInterface;

/**
 * Input message listener.
 *
 * @see InputEvent
 */
@Component
public class InputListener {

    /** Logger. */
    private final Logger logger = LoggerFactory.getLogger(InputListener.class);

    // @Autowired
    // private MessageService messageService;

    /** The service redirector service. */
    @Autowired
    private ServiceRedirectorService serviceRedirectorService;

    /**
     * Method listening input topic name.
     *
     * @param data
     *            the data
     */
    @KafkaListener(topics = "#{'${app.kafka.input-topic-name}'.split(',')}", containerFactory = "inputKafkaListenerContainerFactory")
    public void listen(final InputData<DataSetData> data) {

        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", data);
        }

        DataSetData incomingData = data.getData();
        ServicesInterface repository = serviceRedirectorService.redirect(incomingData);
        if (repository != null) {
            logger.debug("Saving " + incomingData.getClass() + " into mongoDB ", data);
            repository.save(incomingData);
        }
    }

}

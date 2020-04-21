package es.um.asio.inputprocessor.kafka.listener;

import java.awt.event.InputEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.DataSetDataBase;
import es.um.asio.domain.InputData;
import es.um.asio.inputprocessor.kafka.service.ServiceRedirectorService;
import es.um.asio.inputprocessor.service.service.DatasetService;
import es.um.asio.inputprocessor.service.service.KafkaService;

/**
 * Input message listener.
 *
 * @see InputEvent
 */
@Component
public class InputListener {

    /** Logger. */
    private final Logger logger = LoggerFactory.getLogger(InputListener.class);

    /** The service redirector service. */
    @Autowired
    private ServiceRedirectorService serviceRedirectorService;
    
    /** The kafka service. */
    @Autowired
    private KafkaService kafkaService;

    /**
     * Method listening input topic name.
     *
     * @param data
     *            the data
     */
    @KafkaListener(topics = "#{'${app.kafka.input-topic-name}'.split(',')}", containerFactory = "inputKafkaListenerContainerFactory")
    public void listen(final InputData<DataSetData> data) {

        DataSetDataBase incomingData = (DataSetDataBase) data.getData();
        
        DatasetService service = serviceRedirectorService.redirect(incomingData);
        if (service != null) {
            logger.info("Saving {} into DB {}", incomingData.getClass(), data);
            service.save(incomingData);
        }
        
        logger.info("Send data to general kafka topic: {}", data);
        kafkaService.sendGeneralDataTopic(data);
    }

}

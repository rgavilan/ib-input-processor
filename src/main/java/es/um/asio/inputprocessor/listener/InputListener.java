package es.um.asio.inputprocessor.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Input message listener
 */
@Component
public class InputListener {
    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(InputListener.class);
    
    /**
     * Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    /**
     * Topic name
     */
    @Value("${app.kafka.general-topic-name}")
    private String generalTopicName;
    
    /**
     * Method listening input topic name
     * @param message
     */
    @KafkaListener(topics = "#{'${app.kafka.input-topic-name}'.split(',')}")
    public void listen(String message) {
        if(logger.isDebugEnabled()) {
            logger.debug("Received message: {}", message);
        }
        
        // Cuando el mensaje sea recibido es preciso enviarlo al topic general
        kafkaTemplate.send(generalTopicName, message);
        
        if(logger.isDebugEnabled()) {
            logger.debug("Message: {} sended to general topic", message);
        }
    }
}

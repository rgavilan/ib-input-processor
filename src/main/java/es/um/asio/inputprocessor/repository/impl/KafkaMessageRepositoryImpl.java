package es.um.asio.inputprocessor.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import es.um.asio.inputprocessor.repository.MessageRepository;

/**
 * Kafka repository implementation for messages.
 */
@Component
public class KafkaMessageRepositoryImpl implements MessageRepository {
    
    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(KafkaMessageRepositoryImpl.class);
    
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
     * Topic name
     */
    @Value("${app.kafka.management-topic-name}")
    private String managementTopicName;

    @Override
    public void save(String message) {
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

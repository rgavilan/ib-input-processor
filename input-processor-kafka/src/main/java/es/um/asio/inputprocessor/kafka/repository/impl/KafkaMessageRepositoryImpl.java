package es.um.asio.inputprocessor.kafka.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import es.um.asio.inputprocessor.kafka.repository.MessageRepository;

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

    @Override
    public void save(final String message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", message);
        }

        // Cuando el mensaje sea recibido es preciso enviarlo al topic general
        this.kafkaTemplate.send(this.generalTopicName, message);

        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Message: {} sended to general topic", message);
        }
    }

}

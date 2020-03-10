package es.um.asio.inputprocessor.kafka.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.inputprocessor.kafka.repository.MessageRepository;
import es.um.asio.inputprocessor.kafka.service.MessageService;

/**
 * Service implementation to handle message entity related operations
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

    /**
     * Logger
     */
    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    /**
     * Repository for messages.
     */
    @Autowired
    private MessageRepository messageRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public void process(final String message) {
        if (this.logger.isDebugEnabled()) {

            this.logger.debug("Insert new message: {}", message);
        }

        this.messageRepository.save(message);
    }

}

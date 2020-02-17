package es.um.asio.inputprocessor.kafka.repository;

/**
 * Repository for messages.
 */
public interface MessageRepository {
    /**
     * Save a message into the system
     *
     * @param message
     *            The message
     */
    void save(final String message);
}

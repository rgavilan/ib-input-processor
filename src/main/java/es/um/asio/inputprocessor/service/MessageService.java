package es.um.asio.inputprocessor.service;

/**
 * Service to handle message entity related operations
 */
public interface MessageService {
    /**
     * Process a message
     *
     * @param message
     *            The message
     */
    void process(final String message);
}

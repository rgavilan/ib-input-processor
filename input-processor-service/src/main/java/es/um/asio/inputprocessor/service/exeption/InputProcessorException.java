package es.um.asio.inputprocessor.service.exeption;

public class InputProcessorException extends RuntimeException {
    
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6349340066769541752L;

	/**
     * Instantiates a new last import request exception.
     */
    public InputProcessorException() {
        super();
    }    

    public InputProcessorException(String message) {
        super(message);
    }
}

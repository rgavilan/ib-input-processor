package es.um.asio.inputprocessor.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * APP main class.
 */
@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    /**
     * Main method for embedded deployment.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

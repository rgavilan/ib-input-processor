package es.um.asio.inputprocessor.service.test.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import es.um.asio.inputprocessor.service.config.PersistenceConfig;
import es.um.asio.inputprocessor.service.repository.RepositoryConfig;

@SpringBootApplication
@EnableAutoConfiguration
@Import({ PersistenceConfig.class, RepositoryConfig.class })
public class RepositoryTestApplication {
    /**
     * Main method for embedded deployment.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(RepositoryTestApplication.class, args);
    }
}

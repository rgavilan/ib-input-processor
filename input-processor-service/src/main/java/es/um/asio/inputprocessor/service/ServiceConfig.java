package es.um.asio.inputprocessor.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import es.um.asio.inputprocessor.service.config.PersistenceConfig;
import es.um.asio.inputprocessor.service.repository.RepositoryConfig;

/**
 * Service Spring configuration.
 */
@Configuration
@ComponentScan
@Import({RepositoryConfig.class, PersistenceConfig.class})
public class ServiceConfig {

}

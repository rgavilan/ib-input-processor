package es.um.asio.inputprocessor.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import es.um.asio.inputprocessor.service.repository.ProjectRepository;

/**
 * MongoDB related configuration.
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = {ProjectRepository.class})
public class PersistenceConfig {

}

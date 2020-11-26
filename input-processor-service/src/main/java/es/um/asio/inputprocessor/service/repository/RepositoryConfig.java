package es.um.asio.inputprocessor.service.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Service Spring configuration.
 */
@Configuration
@ComponentScan(basePackageClasses = { ProjectRepository.class, ImportEtlResultRepository.class })
public class RepositoryConfig {

}

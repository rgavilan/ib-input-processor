package es.um.asio.inputprocessor.service.config.properties;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

/**
 * Persistence related properties.
 */
@ConfigurationProperties("app.persistence.mongo")
@Validated
@Getter
@Setter
public class PersistenceProperties {
    /**
     * Connection string
     */
    @NotEmpty
    private String connectionString;
    
    /**
     * Secured database configuration.
     */
    @NotEmpty
    private String database;
    
    /**
     * Username for the database.
     */
    private String username;
    
    /**
     * Password for the database.
     */
    private String password;
}

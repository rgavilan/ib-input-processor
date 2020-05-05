package es.um.asio.inputprocessor.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ETL related configuration
 */
@Configuration
public class ETLConfig {
    @Bean
    public RestTemplate cvnRestTemplate() {
        return new RestTemplate();        
    }
}

package es.um.asio.inputprocessor.kafka.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * ETL related configuration
 */
@Configuration
public class ETLConfig {
	@Bean
	public RestTemplate cvnRestTemplate() {

		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
				Arrays.asList(
						MediaType.APPLICATION_JSON,
						MediaType.APPLICATION_OCTET_STREAM, 
						MediaType.APPLICATION_XML, 
						MediaType.TEXT_XML));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

		return restTemplate;
	}
}

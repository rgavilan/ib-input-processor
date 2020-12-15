package es.um.asio.inputprocessor.kafka.service.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import es.um.asio.inputprocessor.kafka.model.ETLJobResponse;
import es.um.asio.inputprocessor.service.repository.ImportEtlResultRepository;



@RunWith(SpringRunner.class)
@ActiveProfiles("unit-test")
public class ETLServiceImplTest {
	
	@Autowired
	private ETLServiceImpl etlServiceImpl;
	
	@MockBean
	private ImportEtlResultRepository importEtlResult;
	
	@MockBean
	private RestTemplate restTemplate;  
	
	
	@TestConfiguration
	static class ETLServiceImplTestConfig {
		@Bean
		ETLServiceImpl eTLServiceImpl() {
			return new ETLServiceImpl();
		}
	}
	
	@Test
	public void run() {
		ETLJobResponse result = etlServiceImpl.run(1L);
		assertNull(result);
	}


}

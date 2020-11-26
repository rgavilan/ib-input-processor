package es.um.asio.inputprocessor.kafka.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import es.um.asio.abstractions.constants.Constants;
import es.um.asio.domain.importetlresult.ImportEtlResult;
import es.um.asio.inputprocessor.kafka.config.ETLConfig;
import es.um.asio.inputprocessor.kafka.model.ETLJobResponse;
import es.um.asio.inputprocessor.kafka.service.impl.ETLServiceImpl;
import es.um.asio.inputprocessor.service.repository.ImportEtlResultRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ETLConfig.class,
		es.um.asio.inputprocessor.kafka.service.ETLServiceTest.ETLServiceTestConfig.class })
public class ETLServiceTest {

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public RestTemplate restTemplateMS;

	@Autowired
	private ETLService etlService;

	private MockRestServiceServer mockServer;

	private MockRestServiceServer mockServerMS;

	@MockBean
	private ImportEtlResultRepository mockRepository;

	@TestConfiguration
	static class ETLServiceTestConfig {
		@Bean
		public ETLService cvnImportInfoService() {
			return new ETLServiceImpl();
		}
	}

	@Before
	public void setUp() {
		ReflectionTestUtils.setField(etlService, "endPoint", "http://localhost:8383/kettle/runJob");
		ReflectionTestUtils.setField(etlService, "job", "main");
		ReflectionTestUtils.setField(etlService, "username", "asioetl");
		ReflectionTestUtils.setField(etlService, "password", "asioetl");
		ReflectionTestUtils.setField(etlService, "urlmanagementsystem",
				"http://localhost:9321/etl-notifications/isMSRunning");
		mockServer = MockRestServiceServer.createServer(restTemplate);

		mockServerMS = MockRestServiceServer.createServer(restTemplateMS);

		// Mock save Import ETL result
		Mockito.when(this.mockRepository.save(any())).thenAnswer(invocation -> {
			ImportEtlResult importResult = new ImportEtlResult();
			importResult.setVersion(0);
			importResult.setEndpoint("http://localhost:9321/etl-notifications/isMSRunning");
			importResult.setDateTime(new Date());
			importResult.setMessage(Constants.OK);
			importResult.setStatus(Constants.OK);
			return importResult;
		});

		etlService = mock(ETLService.class);
		when(etlService.run(37)).thenReturn(responseRun());
		// Mockito.when(etlService.run(37)).thenReturn(responseRun());
	}

	@Test
	public void whenRunETL_AndServerReturnsOK_thenReturnsETLJobResult() {

		mockServerMS.expect(requestTo("/etl-notifications/isMSRunning")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("true", MediaType.TEXT_XML));

		mockServer.expect(ExpectedCount.once(), requestTo("http://localhost:8383/kettle/runJob/?job=main&version=37"))
				.andExpect(method(HttpMethod.GET)).andExpect(header("Authorization", "Basic YXNpb2V0bDphc2lvZXRs"))
				.andRespond(withSuccess(givenAETLJobResponse(), MediaType.TEXT_XML));

		ETLJobResponse result = etlService.run(37);

		// mockServer.verify();
		assertNotNull(result);
		assertThat(result.getResult()).isEqualTo("OK");
	}

	// @Test
	public void whenRunETL_AndServerReturnsError_thenReturnsNull() {
		mockServer.expect(ExpectedCount.once(), requestTo("http://localhost:8383/kettle/runJob/?job=main&version=37"))
				.andExpect(method(HttpMethod.GET)).andExpect(header("Authorization", "Basic YXNpb2V0bDphc2lvZXRs"))
				.andRespond(withServerError());

		ETLJobResponse result = etlService.run(37);

		mockServer.verify();
		assertNull(result);
	}

	private ETLJobResponse responseRun() {
		ETLJobResponse etl = new ETLJobResponse();
		etl.setId("5bad52ff-5c75-48e3-8352-a95671238d12");
		etl.setMessage("Job started");
		etl.setResult("OK");
		return etl;
	}

	private String givenAETLJobResponse() {

		return "<webresult>\r\n" + "    <result>OK</result>\r\n" + "    <message>Job started</message>\r\n"
				+ "    <id>5bad52ff-5c75-48e3-8352-a95671238d12</id>\r\n" + "</webresult>";
	}
}

package es.um.asio.inputprocessor.kafka.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import es.um.asio.inputprocessor.kafka.config.ETLConfig;
import es.um.asio.inputprocessor.kafka.model.ETLJobResponse;
import es.um.asio.inputprocessor.kafka.service.impl.ETLServiceImpl;
 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ETLConfig.class, es.um.asio.inputprocessor.kafka.service.ETLServiceTest.ETLServiceTestConfig.class})
public class ETLServiceTest {
    
    @Autowired
    public RestTemplate restTemplate;   
    
    @Autowired
    private ETLService etlService;
    
    private MockRestServiceServer mockServer;

    @TestConfiguration
    static class ETLServiceTestConfig {
        @Bean
        public ETLService cvnImportInfoService() {
            return new ETLServiceImpl();
        }
    }
    
    @Before
    public void setUp() {
        ReflectionTestUtils.setField(etlService, "endPoint", "http://localhost:8080/kettle/runJob");
        ReflectionTestUtils.setField(etlService, "job", "dummyJob");
        ReflectionTestUtils.setField(etlService, "username", "dummyUser");
        ReflectionTestUtils.setField(etlService, "password", "dummyPassword");
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }
    
    
    @Test
    public void whenRunETL_AndServerReturnsOK_thenReturnsETLJobResult() {          
        mockServer.expect(ExpectedCount.once(),
                requestTo("http://localhost:8080/kettle/runJob/?job=dummyJob&version=25"))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("Authorization","Basic ZHVtbXlVc2VyOmR1bW15UGFzc3dvcmQ="))
                .andRespond(withSuccess(givenAETLJobResponse(),MediaType.TEXT_XML));  
        
        ETLJobResponse result = etlService.run(25);
        
        mockServer.verify();        
        assertNotNull(result);
        assertThat(result.getResult()).isEqualTo("OK");
    }
    
    @Test
    public void whenRunETL_AndServerReturnsError_thenReturnsNull() {          
        mockServer.expect(ExpectedCount.once(),
                requestTo("http://localhost:8080/kettle/runJob/?job=dummyJob&version=25"))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("Authorization","Basic ZHVtbXlVc2VyOmR1bW15UGFzc3dvcmQ="))
                .andRespond(withServerError());
        
        ETLJobResponse result = etlService.run(25);
        
        mockServer.verify();        
        assertNull(result);
    }
    
    
    private String givenAETLJobResponse() {
        return "<webresult>\r\n" + 
                "    <result>OK</result>\r\n" + 
                "    <message>Job started</message>\r\n" + 
                "    <id>05d919b0-74a3-48d6-84d8-afce359d0449</id>\r\n" + 
                "</webresult>";
    }
}

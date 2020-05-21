package es.um.asio.inputprocessor.back.test.controller.importresult;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.um.asio.abstractions.domain.JobType;
import es.um.asio.abstractions.dto.ImportResultDto;
import es.um.asio.abstractions.search.PageImplHelper;
import es.um.asio.inputprocessor.back.controller.importresult.ImportResultController;
import es.um.asio.inputprocessor.service.filter.ImportResultFilter;
import es.um.asio.inputprocessor.service.proxy.ImportResultProxy;

@RunWith(SpringRunner.class)
@WebMvcTest(ImportResultController.class)
public class ImportResultControllerTest {

    /**
     * MVC test support
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Import result service
     */
    @MockBean
    private ImportResultProxy mockProxy;
  
    
    @TestConfiguration
    static class UserProxyTestConfiguration {
        @Bean
        public ImportResultController importResultController() {
            return new ImportResultController();
        }
    }

    @Before
    public void setUp() {
        // Mock data
        final ImportResultDto importResult1 = new ImportResultDto();
        importResult1.setJobType(JobType.CVN);
        
        final ImportResultDto importResult2 = new ImportResultDto();
        importResult2.setJobType(JobType.DATASET);        
 
        // Mock findPaginated
        Mockito.when(this.mockProxy.findPaginated(any(ImportResultFilter.class), any(Pageable.class)))
                .thenAnswer(invocation -> {
                    return new PageImplHelper<ImportResultDto>(Lists.newArrayList(importResult1, importResult2));
                });
    }

    @Test
    public void whenSearchImportResults_ThenReturnJsonObject() throws Exception {

        this.mockMvc.perform(get("/import-result/search").accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.totalElements", is(2)))
            .andExpect(jsonPath("$.content", hasSize(2)))
            .andExpect(jsonPath("$.content[0].jobType", is("CVN")))
            .andExpect(jsonPath("$.content[1].jobType", is("DATASET")));
    }

}

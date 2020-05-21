package es.um.asio.inputprocessor.service.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.abstractions.search.PageImplHelper;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.service.filter.ImportResultFilter;
import es.um.asio.inputprocessor.service.repository.ImportResultRepository;
import es.um.asio.inputprocessor.service.service.ImportResultService;
import es.um.asio.inputprocessor.service.service.impl.ImportResultServiceImpl;

@RunWith(SpringRunner.class)
public class ImportResultServiceTest {
    
    /**
     * Import result service.
     */
    @Autowired
    private ImportResultService service;
    
    /**
     * Import result repository.
     */
    @MockBean
    private ImportResultRepository mockRepository;
    
    @TestConfiguration
    static class DatasetGenericServiceConfiguration {
        @Bean
        public ImportResultService importResultService() {
            return new ImportResultServiceImpl();
        }
    }       
    
    @Before
    public void setUp() {
        // Sample data
        final ImportResult importResult1 = new ImportResult();
        importResult1.setEntityId("1");

        final ImportResult importResult2 = new ImportResult();
        importResult2.setEntityId("2");        
       
        // Mock findAll - page
        Mockito.when(this.mockRepository.findAll(any(ImportResultFilter.class), any(Pageable.class))).thenAnswer(invocation -> {
            final List<ImportResult> elements = Lists.newArrayList(importResult1, importResult2);
            final Pageable page = invocation.getArgument(1);
            return new PageImplHelper<ImportResult>(elements, page, elements.size());
        });
    }

    @Test
    public void whenFindPaginated_thenReturnPage() {
        final ImportResultFilter filter = new ImportResultFilter();
        final Page<ImportResult> page = this.service.findPaginated(filter, PageRequest.of(0, 10));
        assertThat(page.getNumberOfElements()).isNotEqualTo(0);
    }
    
}

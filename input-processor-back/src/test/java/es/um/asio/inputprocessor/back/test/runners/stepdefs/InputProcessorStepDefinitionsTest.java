package es.um.asio.inputprocessor.back.test.runners.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assume;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import es.um.asio.abstractions.domain.ExitStatusCode;
import es.um.asio.abstractions.domain.JobType;
import es.um.asio.abstractions.dto.ImportResultDto;
import es.um.asio.inputprocessor.back.controller.importresult.ImportResultController;
import es.um.asio.inputprocessor.service.filter.ImportResultFilter;
import es.um.asio.inputprocessor.service.proxy.ImportResultProxy;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ImportResultController.class)
public class InputProcessorStepDefinitionsTest {

	@MockBean
	@Autowired
	private ImportResultProxy proxy;

	ImportResultFilter filter;

	Pageable pageable;

	@Before
	public void setUp() {
		filter = new ImportResultFilter();
		filter.setExitStatusCode(ExitStatusCode.COMPLETED);
		filter.setJobType(JobType.DATASET);

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));
		// Mock proxy
		Mockito.when(this.proxy.findPaginated(filter, pageable)).thenAnswer(invocation -> {

			List<ImportResultDto> contentResult = new ArrayList<>();
			ImportResultDto result = new ImportResultDto();
			result.setExitStatusCode(ExitStatusCode.COMPLETED);
			result.setJobType(JobType.DATASET);
			result.setStartTime(new Date());

			contentResult.add(result);

			Page<ImportResultDto> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

	}

	@Given("^call to backend  input result controller$")
	public void call_to_backend_input_result_controller() {
		assertNotNull(filter);
	}

	@Then("^the controller call to servie and find result to send response$")
	public void the_controller_call_to_servie_and_find_result_to_send_response() {

		Page<ImportResultDto> page = this.proxy.findPaginated(filter, pageable);
		assertNotNull(page);

		assertEquals(JobType.DATASET, page.getContent().get(0).getJobType());

	}

	@Given("^read oai-pmh$")
	public void read_oai_pmh() {
		Assume.assumeTrue(false);
	}

	@Then("^the service process oai-pmh data$")
	public void the_service_process_oai_pmh_data() {
		Assume.assumeTrue(false);
	}

}

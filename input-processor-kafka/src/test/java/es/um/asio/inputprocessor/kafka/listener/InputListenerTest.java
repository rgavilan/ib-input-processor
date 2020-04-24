package es.um.asio.inputprocessor.kafka.listener;


import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.DataSetDataBase;
import es.um.asio.domain.InputData;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.inputprocessor.kafka.helper.DummyDataSetData;
import es.um.asio.inputprocessor.kafka.service.KafkaService;
import es.um.asio.inputprocessor.kafka.service.ServiceRedirectorService;
import es.um.asio.inputprocessor.service.service.DatasetService;

@RunWith(SpringRunner.class)
public class InputListenerTest {

    @TestConfiguration
    static class InputListenerTestConfiguration {
        @Bean
        public InputListener inputListener() {
            return new InputListener();
        }
    }   
    @Autowired
    private InputListener inputListener;
    
    @MockBean
    private KafkaService kafkaService;
    
    @MockBean
    private ServiceRedirectorService serviceRedirectorService;
    
    
    @Test
    public void whenListenARegularInputData_thenSendToGeneralDataTopic() {        
        InputData<DataSetData> inputData = givenAnInputData();
        
        inputListener.listen(inputData);
        
        verify(kafkaService).sendGeneralDataTopic(inputData);
    }
    
    @Test
    public void whenListenAnImportResultData_thenNotSendGeneralDataTopic() {        
        InputData<DataSetData> importResultData = new InputData<DataSetData>(new ImportResult());
        
        inputListener.listen(importResultData);
        
        verify(kafkaService, never()).sendGeneralDataTopic(importResultData);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void whenListenAnInputData_thenSaveWithDataService() {
        DatasetService dataService = Mockito.mock(DatasetService.class);
        Mockito.when(serviceRedirectorService.redirect(any(DataSetData.class))).thenReturn(dataService);
        InputData<DataSetData> inputData = givenAnInputData();

        inputListener.listen(inputData);
        
        verify(dataService).save((DataSetDataBase)inputData.getData());
    }
    
    private InputData<DataSetData> givenAnInputData(){
        return new InputData<DataSetData>(new DummyDataSetData());
    }    
}

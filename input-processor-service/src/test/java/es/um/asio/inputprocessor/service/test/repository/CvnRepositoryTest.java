package es.um.asio.inputprocessor.service.test.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.domain.cvn.Cvn;
import es.um.asio.domain.cvn.CvnAuthorBean;
import es.um.asio.domain.cvn.CvnDuration;
import es.um.asio.domain.cvn.CvnItemBean;
import es.um.asio.inputprocessor.service.repository.generic.DatasetGenericRepository;

/**
 * Test for {@link CvnRepositoryTest}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CvnRepositoryTest {
    
    /** 
     * The cvn repository. 
     * */
    @Autowired
    private DatasetGenericRepository cvnRepository;
    
    /**
     * When save new cvn then no error.
     */
    @Test
    public void whenSaveCvn_thenCvnSavedIsNotNull() {
        Cvn cvn = givenACvn();
        
        Cvn cvnSaved = cvnRepository.save(cvn);
        
        assertNotNull(cvnSaved);
    }
        
    /**
     * Given A cvn.
     *
     * @return the cvn
     */
    private Cvn givenACvn() {
        CvnAuthorBean author = new CvnAuthorBean();
        author.setGivenName("dummyName");
        author.setCode("dummyAuthorCode");        
        CvnDuration duration = new CvnDuration();
        duration.setCode("dummyDurationCode");
        duration.setValue("dummyValue");
        
        CvnItemBean cvnItem = new CvnItemBean();
        cvnItem.setCvnAuthorBean(Arrays.asList(author));
        cvnItem.setCvnDuration(Arrays.asList(duration));
 
        Cvn cvn = new Cvn();
        cvn.setCvnItemBean(Arrays.asList(cvnItem));
        
        return cvn;
    }
}

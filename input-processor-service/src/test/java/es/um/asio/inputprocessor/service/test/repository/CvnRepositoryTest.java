/*
 * 
 */
package es.um.asio.inputprocessor.service.test.repository;

import static org.junit.Assert.assertNotNull;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.domain.cvn.CvnRootBean;
import es.um.asio.inputprocessor.service.repository.CvnRootBeanRepository;

/**
 * Test for {@link CvnRootBeanRepository}.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CvnRepositoryTest {
    
    @Autowired
    private CvnRootBeanRepository cvnRootBeanRepository;
    
 
    @Test
    public void whenSaveCvnRootBean_thenCvnSavedIsNotNull() {
        CvnRootBean cvnRootBean = new CvnRootBean();
        
        CvnRootBean cvnSaved = cvnRootBeanRepository.save(cvnRootBean);
        
        assertNotNull(cvnSaved);
    }
   
    @Test
    public void whenSaveCvnRootBean_thenCvnSavedHasId() {
        CvnRootBean cvnRootBean = new CvnRootBean();
        
        CvnRootBean cvnSaved = cvnRootBeanRepository.save(cvnRootBean);
        
        assertNotNull(cvnSaved.getEntityId());
    }
    
    
    @Test
    public void whenSaveAComplexCvnRootBean_thenCvnSavedHasId() {
        CvnRootBean cvnRootBean = givenAComplexCvnRootBean();
        
        CvnRootBean cvnSaved = cvnRootBeanRepository.save(cvnRootBean);
        
        assertNotNull(cvnSaved.getEntityId());
    }
    
   
    @Test
    public void whenSaveCvnRootBean_thenNestedEntitiesHasId() {
        CvnRootBean cvnRootBean = givenAComplexCvnRootBean();
        
        CvnRootBean cvnSaved = cvnRootBeanRepository.save(cvnRootBean);
        
        assertNotNull(cvnSaved.getCvnItemBean().get(0).getEntityId());
        assertNotNull(cvnSaved.getCvnItemBean().get(0).getCvnAuthorBean().get(0).getEntityId());
        assertNotNull(cvnSaved.getCvnItemBean().get(0).getCvnAuthorBean().get(0).getCvnFamilyNameBean().getEntityId());
    }
        
    
    private CvnRootBean givenAComplexCvnRootBean() {
        EasyRandomParameters parameters = new EasyRandomParameters().excludeField(FieldPredicates.named("entityId"));
        EasyRandom generator = new EasyRandom(parameters);
        CvnRootBean cvnRootBean = generator.nextObject(CvnRootBean.class);
        
        return cvnRootBean;
    }
}

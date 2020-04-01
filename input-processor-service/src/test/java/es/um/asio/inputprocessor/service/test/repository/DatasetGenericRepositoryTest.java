package es.um.asio.inputprocessor.service.test.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.domain.proyectos.Proyecto;
import es.um.asio.inputprocessor.service.repository.generic.DatasetGenericRepository;

/**
 * Test for {@link DatasetGenericRepository}
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DatasetGenericRepositoryTest {
    /**
     * Dataset generic repository.
     */
    @Autowired
    private DatasetGenericRepository repository;
    
    @Test
    public void whenSaveNewDataset_thenDatasetHasId() {
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(1L);
        proyecto.setNombre("Test");
        
        repository.save(proyecto);
        assertNotNull(proyecto.getEntityId());
    }
}

package es.um.asio.inputprocessor.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.cvn.CvnRootBean;
import es.um.asio.inputprocessor.service.repository.CvnRootBeanRepository;
import es.um.asio.inputprocessor.service.service.CvnRootBeanService;

/**
 * {@link CvnRootBean} service implementation.
 */
@Service
public class CvnRootBeanServiceImp implements CvnRootBeanService {

    /**
     * {@link CvnRootBean} repository.
     */
    @Autowired
    private CvnRootBeanRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public CvnRootBean save(final CvnRootBean cvnRootBean) {
        return this.repository.save(cvnRootBean);
    }
}

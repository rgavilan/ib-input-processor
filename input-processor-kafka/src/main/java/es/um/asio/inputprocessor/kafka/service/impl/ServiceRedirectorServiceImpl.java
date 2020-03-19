package es.um.asio.inputprocessor.kafka.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.importResult.ImportResult;
import es.um.asio.domain.gruposInvestigacion.DatosContactoGrupo;
import es.um.asio.domain.gruposInvestigacion.GrupoInvestigacion;
import es.um.asio.domain.proyectos.FechaProyecto;
import es.um.asio.domain.proyectos.JustificacionPrevistaProyecto;
import es.um.asio.domain.proyectos.Proyecto;
import es.um.asio.domain.proyectos.OrigenProyecto;
import es.um.asio.inputprocessor.kafka.service.ServiceRedirectorService;
import es.um.asio.inputprocessor.service.service.DateProjectsService;
import es.um.asio.inputprocessor.service.service.GroupContactDataService;
import es.um.asio.inputprocessor.service.service.ImportResultService;
import es.um.asio.inputprocessor.service.service.InvestigationGroupService;
import es.um.asio.inputprocessor.service.service.PlannedJustificationsProjectService;
import es.um.asio.inputprocessor.service.service.ProjectOriginsService;
import es.um.asio.inputprocessor.service.service.ProjectService;
import es.um.asio.inputprocessor.service.service.ServicesInterface;

/**
 * Service implementation to handle message entity related operations.
 */
@Service
public class ServiceRedirectorServiceImpl implements ServiceRedirectorService {

    /** Logger. */
    private final Logger logger = LoggerFactory.getLogger(ServiceRedirectorServiceImpl.class);

    /** The project service. */
    @Autowired
    private ProjectService projectService;

    /** The planned justifications project service. */
    @Autowired
    private PlannedJustificationsProjectService plannedJustificationsProjectService;

    /** The project origins service. */
    @Autowired
    private ProjectOriginsService projectOriginsService;

    /** The date projects service. */
    @Autowired
    private DateProjectsService dateProjectsService;

    /** The investigation group service. */
    @Autowired
    private InvestigationGroupService investigationGroupService;

    /** The group contact data service. */
    @Autowired
    private GroupContactDataService groupContactDataService;
    
    /** The import result service. */
    @Autowired
    private ImportResultService importResultService;

    /** The do by class. */
    private Map<Object, Object> doByClass = new HashMap<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        doByClass.put(Proyecto.class, projectService);
        doByClass.put(JustificacionPrevistaProyecto.class, plannedJustificationsProjectService);
        doByClass.put(OrigenProyecto.class, projectOriginsService);
        doByClass.put(FechaProyecto.class, dateProjectsService);
        doByClass.put(GrupoInvestigacion.class, investigationGroupService);
        doByClass.put(DatosContactoGrupo.class, groupContactDataService);
        doByClass.put(ImportResult.class, importResultService);
    }

    /**
     * Redirect.
     *
     * @param data
     *            the data
     * @return the services interface
     */
    @Override
    public ServicesInterface redirect(DataSetData data) {
        return (ServicesInterface) doByClass.get(data.getClass());
    }

}

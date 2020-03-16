package es.um.asio.inputprocessor.kafka.listener;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ClassUtils.Interfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.InputData;
import es.um.asio.domain.investigationCenter.GroupContactData;
import es.um.asio.domain.investigationGroup.InvestigationGroup;
import es.um.asio.domain.project.DateProjects;
import es.um.asio.domain.project.PlannedJustificationsProject;
import es.um.asio.domain.project.Project;
import es.um.asio.domain.project.ProjectOrigins;
import es.um.asio.inputprocessor.kafka.service.MessageService;
import es.um.asio.inputprocessor.service.service.DateProjectsService;
import es.um.asio.inputprocessor.service.service.GroupContactDataService;
import es.um.asio.inputprocessor.service.service.InvestigationGroupService;
import es.um.asio.inputprocessor.service.service.PlannedJustificationsProjectService;
import es.um.asio.inputprocessor.service.service.ProjectOriginsService;
import es.um.asio.inputprocessor.service.service.ProjectService;
import es.um.asio.inputprocessor.service.service.ServicesInterface;

/**
 * Input message listener.
 *
 * @see InputEvent
 */
@Component
public class InputListener {

    /** Logger. */
    private final Logger logger = LoggerFactory.getLogger(InputListener.class);

    // @Autowired
    // private MessageService messageService;

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

    @Autowired
    private GroupContactDataService groupContactDataService;

    /**
     * Method listening input topic name.
     *
     * @param data
     *            the data
     */
    @KafkaListener(topics = "#{'${app.kafka.input-topic-name}'.split(',')}", containerFactory = "inputKafkaListenerContainerFactory")
    public void listen(final InputData<DataSetData> data) {
        // TODO move to service
        Map<Object, Object> doByClass = new HashMap<>();
        doByClass.put(Project.class, projectService);
        doByClass.put(PlannedJustificationsProject.class, plannedJustificationsProjectService);
        doByClass.put(ProjectOrigins.class, projectOriginsService);
        doByClass.put(DateProjects.class, dateProjectsService);
        doByClass.put(InvestigationGroup.class, investigationGroupService);
        doByClass.put(GroupContactData.class, groupContactDataService);

        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", data);
        }

        DataSetData incomingData = data.getData();
        ServicesInterface repository = (ServicesInterface) doByClass.get(incomingData.getClass());
        if (repository != null) {
            logger.debug("Saving " + incomingData.getClass() + " into mongoDB ", data);
            repository.save(incomingData);
        }
    }

}

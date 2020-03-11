package es.um.asio.inputprocessor.kafka.listener;

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
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Received message: {}", data);
        }

        DataSetData incomingData = data.getData();
        if (incomingData instanceof Project) {
            if (logger.isDebugEnabled()) {
                logger.debug("Saving project into mongoDB ", data);
            }
            projectService.save((Project) incomingData);
        } else if (incomingData instanceof PlannedJustificationsProject) {
            if (logger.isDebugEnabled()) {
                logger.debug("Saving PlannedJustificationsProject into mongoDB ", data);
            }
            plannedJustificationsProjectService.save((PlannedJustificationsProject) incomingData);
        } else if (incomingData instanceof ProjectOrigins) {
            if (logger.isDebugEnabled()) {
                logger.debug("Saving projectOrigins into mongoDB ", data);
            }
            projectOriginsService.save((ProjectOrigins) incomingData);
        } else if (incomingData instanceof DateProjects) {
            if (logger.isDebugEnabled()) {
                logger.debug("Saving dateProjects into mongoDB ", data);
            }
            dateProjectsService.save((DateProjects) incomingData);
        } else if (incomingData instanceof InvestigationGroup) {
            if (logger.isDebugEnabled()) {
                logger.debug("Saving investigationGroup into mongoDB ", data);
            }
            investigationGroupService.save((InvestigationGroup) incomingData);
        } else if (incomingData instanceof GroupContactData) {
            if (logger.isDebugEnabled()) {
                logger.debug("Saving groupContacData into mongoDB ", data);
            }
            groupContactDataService.save((GroupContactData) incomingData);
        }
    }

}

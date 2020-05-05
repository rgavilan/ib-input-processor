package es.um.asio.inputprocessor.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Kafka admin related configuration
 */
@ConditionalOnProperty(prefix = "app.kafka", name = "create-topics", havingValue = "true", matchIfMissing = false)
@Configuration
public class KafkaAdminConfig {
    
    /**
     * Input topic name.
     */
    @Value("${app.kafka.input-topic-name}")
    private String inputTopicName;
   
    /** The general contingency topic name. */
    @Value("${app.kafka.general-contingency-topic-name}")
    private String generalContingencyTopicName;

    /**
     * Input topic.
     * @return
     */
    @Bean
    public NewTopic inputTopic() {
        return new NewTopic(this.inputTopicName, 1, (short) 1);
    }
        
    /**
     * General contingency topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic generalContingencyTopic() {
        return new NewTopic(this.generalContingencyTopicName, 1, (short) 1);
    }

}

package es.um.asio.inputprocessor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Kafka related configuration
 */
@EnableKafka
@Configuration
public class KafkaConfig {
    
    /**
     * Input topic name.
     */
    @Value("app.kafka.input-topic-name")
    private String inputTopicName;
    
    /**
     * Input topic name.
     */
    @Value("app.kafka.general-topic-name")
    private String generalTopicName;

    /**
     * Input topic.
     * @return
     */
    @Bean
    public NewTopic inputTopic() {
        return new NewTopic(this.inputTopicName, 1, (short) 1);
    }
    
    /**
     * General topic.
     * @return
     */
    @Bean
    public NewTopic generalTopic() {
        return new NewTopic(this.generalTopicName, 1, (short) 1);
    }
}

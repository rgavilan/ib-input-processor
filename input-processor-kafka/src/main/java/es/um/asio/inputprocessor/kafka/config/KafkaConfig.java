package es.um.asio.inputprocessor.kafka.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import es.um.asio.domain.DataSetData;
import es.um.asio.domain.InputData;
import es.um.asio.inputprocessor.service.ServiceConfig;

/**
 * Kafka related configuration
 */
@EnableKafka
@Configuration
@Import(ServiceConfig.class)
public class KafkaConfig {
    /**
     * Kafka properties.
     */
    @Autowired
    private KafkaProperties kafkaProperties;

    /**
     * Input data consumer factory.
     * 
     * @return {@link ConsumerFactory}.
     */
    public ConsumerFactory<String, InputData<DataSetData>> inputDataConsumerFactory() {

        // ObjectMapper mapper = new ObjectMapper()
        // .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        // .registerModule(new SimpleModule() {
        // {
        // addDeserializer(DataSetData.class, new com.fasterxml.jackson.databind.JsonDeserializer<DataSetData>() {
        //
        // @Override
        // public DataSetData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException,
        // JsonProcessingException {
        // // TODO
        // return new Project();
        // }
        //
        // });
        // }
        // });

        return new DefaultKafkaConsumerFactory<>(this.kafkaProperties.getConsumer().buildProperties(),
                new StringDeserializer(), new JsonDeserializer<>(InputData.class));
    }

    /**
     * Input kafka listener container factory.
     *
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, InputData<DataSetData>> inputKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, InputData<DataSetData>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(this.inputDataConsumerFactory());
        return factory;
    }
}

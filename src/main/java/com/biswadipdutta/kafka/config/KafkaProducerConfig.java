package com.biswadipdutta.kafka.config;

import com.biswadipdutta.kafka.serialization.MessageSerializer;
import com.biswadipdutta.kafka.model.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${uri}")
    String URI;

    @Bean
    public ProducerFactory<String, List<Message>> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, URI);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public KafkaTemplate<String, List<Message>> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
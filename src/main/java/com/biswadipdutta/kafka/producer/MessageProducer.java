package com.biswadipdutta.kafka.producer;

import com.biswadipdutta.kafka.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MessageProducer {

    private final KafkaTemplate<String, List<Message>> kafkaTemplate;

    public void sendMessage(String topic, List<Message> message) {
        kafkaTemplate.send(topic, message);
    }
}
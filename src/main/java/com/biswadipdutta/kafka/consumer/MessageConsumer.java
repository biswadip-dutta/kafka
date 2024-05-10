package com.biswadipdutta.kafka.consumer;

import com.biswadipdutta.kafka.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class MessageConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group-id")
    public void listen(List<Message> message) {
        log.info(message);
    }

    @KafkaListener(topics = "test-topic", groupId = "my-group-id")
    public void testListen(List<Message> message) {
        log.info(message);
    }
}
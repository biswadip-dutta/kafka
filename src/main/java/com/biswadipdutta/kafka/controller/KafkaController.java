package com.biswadipdutta.kafka.controller;

import com.biswadipdutta.kafka.model.Message;
import com.biswadipdutta.kafka.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class KafkaController {

    private final MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestBody List<Message> message) {
        messageProducer.sendMessage("my-topic", message);
        messageProducer.sendMessage("test-topic", message);
        return "Message sent";
    }
}
package com.biswadipdutta.kafka.serialization;

import com.biswadipdutta.kafka.model.Message;
import org.apache.kafka.common.serialization.Serializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MessageSerializer implements Serializer<List<Message>> {

    @Override
    public byte[] serialize(String topic, List<Message> data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(data);
        } catch (Exception e) {
            return null;
        }
    }
}

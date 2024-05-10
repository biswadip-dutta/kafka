package com.biswadipdutta.kafka.serialization;

import com.biswadipdutta.kafka.model.Message;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MessageDeserializer implements Deserializer<List<Message>> {

    @Override
    public List<Message> deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, new TypeReference<>() {
            });
        } catch (Exception e) {
            return null;
        }
    }
}

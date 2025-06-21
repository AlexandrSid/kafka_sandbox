package com.aleksid.kafka_listener.listener;

import com.aleksid.kafka_listener.dto.event.UserSubscribeEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSubscribeEventListener {
    private final ObjectMapper mapper;

    @KafkaListener(topics = "user_subscribe", groupId = "test-group")
    public void listen(String json) {
        try {
            UserSubscribeEvent event = mapper.readValue(json, UserSubscribeEvent.class);
            System.out.println("UserSubscribeEvent received: " + event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.aleksid.kafka_listener.listener;

import com.aleksid.kafka_listener.dto.event.GoalCompletedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoalCompleteEventListener {
    private final ObjectMapper mapper;

    @KafkaListener(topics = "goal_completed", groupId = "test-group")
    public void listen(String json) {
        try {
            GoalCompletedEvent event = mapper.readValue(json, GoalCompletedEvent.class);
            System.out.println("GoalCompletedEvent received: " + event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.aleksid.kafka_reporter;

import com.aleksid.kafka_reporter.dto.event.GoalCompletedEvent;
import com.aleksid.kafka_reporter.dto.event.UserSubscribeEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    @GetMapping("/send/{message}")
    public ResponseEntity<Void> sendCustomMessage(@PathVariable String message) {
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("test-topic", message);
        String string = send.join().toString();
        System.out.println(string);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/send/goal_complete/{title}")
    public ResponseEntity<Void> sendGoalComplete(@PathVariable String title) throws JsonProcessingException {
        GoalCompletedEvent event = new GoalCompletedEvent(1L, title, List.of(1L, 2L), LocalDateTime.now());
        String json = mapper.writeValueAsString(event);
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("goal_completed", json);
        String string = send.join().toString();
        System.out.println(string);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/send/user_follow/{follower}/{followee}")
    public ResponseEntity<Void> sendUserFollow(@PathVariable Long follower, @PathVariable Long followee) throws JsonProcessingException {
        UserSubscribeEvent event = new UserSubscribeEvent(followee, follower, LocalDateTime.now());
        String json = mapper.writeValueAsString(event);
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("user_subscribe", json);
        String string = send.join().toString();
        System.out.println(string);
        return ResponseEntity.ok().build();
    }
}

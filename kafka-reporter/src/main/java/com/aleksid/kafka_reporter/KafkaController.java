package com.aleksid.kafka_reporter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send/{message}")
    public ResponseEntity<Void> send(@PathVariable String message) {
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("test-topic", message);
        String string = send.join().toString();
        System.out.println(string);
        return ResponseEntity.ok().build();
    }
}

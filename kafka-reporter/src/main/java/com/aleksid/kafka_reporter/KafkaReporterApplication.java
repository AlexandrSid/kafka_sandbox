package com.aleksid.kafka_reporter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaReporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaReporterApplication.class, args);
	}
}

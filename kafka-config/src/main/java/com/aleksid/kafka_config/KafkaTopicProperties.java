package com.aleksid.kafka_config;

import lombok.Data;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka")
@Data
public class KafkaTopicProperties {
    private List<TopicConfig> topics;
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;

    @Data
    public static class TopicConfig {
        String name;
        int partitions;
        int replicas;
    }
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> config = new HashMap<>();
//        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        return new KafkaAdmin(config);
//    }
}

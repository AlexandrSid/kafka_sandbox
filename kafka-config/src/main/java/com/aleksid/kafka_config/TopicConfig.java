package com.aleksid.kafka_config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic goalCompleted() {
        return TopicBuilder.name("goal_completed")
                .partitions(3)      // 3 партиции уже сейчас
                .replicas(1)        // пока один брокер. На стадии 4 → 3
                .build();
    }

    @Bean
    public NewTopic userSubscribe() {
        return TopicBuilder.name("user_subscribe")
                .partitions(3)
                .replicas(1)
                .build();
    }
}

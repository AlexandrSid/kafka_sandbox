package com.aleksid.kafka_reporter.dto.event;

import java.time.LocalDateTime;

public record UserSubscribeEvent(Long followeeId, Long followerId, LocalDateTime time){
}

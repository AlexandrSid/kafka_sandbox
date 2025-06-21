package com.aleksid.kafka_listener.dto.event;

import java.time.LocalDateTime;

public record UserSubscribeEvent (Long followeeId, Long followerId, LocalDateTime time){
}

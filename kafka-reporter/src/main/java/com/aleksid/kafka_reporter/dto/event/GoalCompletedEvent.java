package com.aleksid.kafka_reporter.dto.event;

import java.time.LocalDateTime;
import java.util.List;

public record GoalCompletedEvent(Long goalId, String goalTitle, List<Long> userIds, LocalDateTime time) {
}

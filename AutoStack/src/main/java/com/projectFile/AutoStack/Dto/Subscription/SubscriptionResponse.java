package com.projectFile.AutoStack.Dto.Subscription;

import java.time.Instant;

public record SubscriptionResponse(
        ActivePlanResponse activePlan,
        String status,
        Instant endOn,
        Long TokenUsedInCycle

) {
}

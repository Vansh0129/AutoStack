package com.projectFile.AutoStack.Dto.Subscription;

public record PlanLimitResponse(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProject,
        Boolean unlimitedAi
)  {
}

package com.projectFile.AutoStack.Dto.Subscription;


public record ActivePlanResponse(
        Long id,
        String name,
        String stripeId,
        Integer maxProjects,
        Long maxTokensPerDay,
        Integer maxPreviews
        ) {
}

package com.projectFile.AutoStack.Dto.Subscription;

public record TodaysUsageResponse(
        Long tokensUsed,
        Long tokensLimit,
        Long previewsLimit,
        Long previewsRunning
) {

}

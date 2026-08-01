package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Subscription.PlanLimitResponse;
import com.projectFile.AutoStack.Dto.Subscription.TodaysUsageResponse;
import org.springframework.stereotype.Service;

@Service
public interface UsageService {
    TodaysUsageResponse TodayUsage(Long userId);

    PlanLimitResponse GetCurrentSubscriptionLimit(Long userId);
}

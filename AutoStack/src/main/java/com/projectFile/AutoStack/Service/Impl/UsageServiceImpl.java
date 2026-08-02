package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Subscription.PlanLimitResponse;
import com.projectFile.AutoStack.Dto.Subscription.TodaysUsageResponse;
import com.projectFile.AutoStack.Service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public TodaysUsageResponse TodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse GetCurrentSubscriptionLimit(Long userId) {
        return null;
    }
}

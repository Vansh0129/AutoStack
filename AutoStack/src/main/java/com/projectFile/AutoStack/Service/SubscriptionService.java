package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse GetCurrentSubscription(Long userId);  //regarding User Info
}

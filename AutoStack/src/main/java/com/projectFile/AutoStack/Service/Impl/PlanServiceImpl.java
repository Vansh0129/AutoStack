package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Subscription.ActivePlanResponse;
import com.projectFile.AutoStack.Dto.Subscription.CheckOutResponse;
import com.projectFile.AutoStack.Dto.Subscription.CheckoutRequest;
import com.projectFile.AutoStack.Dto.Subscription.CustomPortalResponse;
import com.projectFile.AutoStack.Service.PlanService;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {


    @Override
    public ActivePlanResponse GetAllActivePlan(Long userId) {
        return null;
    }

    @Override
    public CheckOutResponse creteCheckOutSessionURL(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public CustomPortalResponse OpenCustomPortal(Long userId) {
        return null;
    }
}

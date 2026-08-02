package com.projectFile.AutoStack.Service.Impl;

import com.projectFile.AutoStack.Dto.Subscription.*;
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

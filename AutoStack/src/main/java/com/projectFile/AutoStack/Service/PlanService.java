package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Subscription.ActivePlanResponse;
import com.projectFile.AutoStack.Dto.Subscription.CheckOutResponse;
import com.projectFile.AutoStack.Dto.Subscription.CheckoutRequest;
import com.projectFile.AutoStack.Dto.Subscription.CustomPortalResponse;
import org.springframework.stereotype.Service;

@Service
public interface PlanService {


    ActivePlanResponse GetAllActivePlan(Long userId) ;

    CheckOutResponse creteCheckOutSessionURL(CheckoutRequest request, Long userId);

    CustomPortalResponse OpenCustomPortal(Long userId);
}

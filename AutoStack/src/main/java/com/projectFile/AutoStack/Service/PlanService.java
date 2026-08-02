package com.projectFile.AutoStack.Service;

import com.projectFile.AutoStack.Dto.Subscription.*;
import org.springframework.stereotype.Service;

@Service
public interface PlanService {


    ActivePlanResponse GetAllActivePlan(Long userId) ;

    CheckOutResponse creteCheckOutSessionURL(CheckoutRequest request, Long userId);

    CustomPortalResponse OpenCustomPortal(Long userId);
}

package com.projectFile.AutoStack.Controller;

import com.projectFile.AutoStack.Dto.Subscription.*;
import com.projectFile.AutoStack.Service.PlanService;
import com.projectFile.AutoStack.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plans")
    public ResponseEntity<ActivePlanResponse>  ActivePlan(){
        Long userId=1l;
       return ResponseEntity.ok( planService.GetAllActivePlan(userId));

    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse>  GetMySubscription(){
        Long userId=1l;
        return  ResponseEntity.ok( subscriptionService.GetCurrentSubscription(userId));

    }
    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckOutResponse>  CheckOutPayment(@RequestBody CheckoutRequest request){
        Long userId=1l;
        return  ResponseEntity.ok( planService.creteCheckOutSessionURL(request,userId));

    }

    @GetMapping("/api/stripe/portal")
    public ResponseEntity<CustomPortalResponse>  OpenCustomPortal(){
        Long userId=1l;
        return  ResponseEntity.ok( planService.OpenCustomPortal(userId));

    }

}

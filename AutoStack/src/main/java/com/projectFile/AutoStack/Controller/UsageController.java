package com.projectFile.AutoStack.Controller;

import com.projectFile.AutoStack.Dto.Subscription.PlanLimitResponse;
import com.projectFile.AutoStack.Dto.Subscription.TodaysUsageResponse;
import com.projectFile.AutoStack.Service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
public class UsageController {

    private  final UsageService usageService;
    @GetMapping("/today")
    public ResponseEntity<TodaysUsageResponse> TodayUsage(){
        Long userId= 1L;
        return ResponseEntity.ok(usageService.TodayUsage(userId));
    }
    @GetMapping("/limits")
    public ResponseEntity<PlanLimitResponse> DailyLimits(){
        Long userId= 1L;
        return ResponseEntity.ok(usageService.GetCurrentSubscriptionLimit(userId));

    }
}

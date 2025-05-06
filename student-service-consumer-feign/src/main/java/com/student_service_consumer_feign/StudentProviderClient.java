package com.student_service_consumer_feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "student-service-provider")
public interface StudentProviderClient {

    @GetMapping("/provider/show")
    String getProviderMessage();
}

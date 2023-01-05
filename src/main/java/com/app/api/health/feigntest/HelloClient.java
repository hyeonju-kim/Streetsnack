//package com.app.api.health.feigntest;
//
//import com.app.api.health.dto.HealthCheckResponseDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@FeignClient(url = "http://localhost:8080", name = "helloClient")
//public interface HelloClient {
//    @GetMapping(value = "/", consumes = "application/json")
//    HealthCheckResponseDto healthCheck();
//}

//package com.app;
//
//import com.app.api.health.feigntest.HelloClient;
//import com.app.api.health.dto.HealthCheckResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class AppRunner implements ApplicationRunner {
//
//
//    private volatile Integer a;
//
//    private final HelloClient helloClient;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("==============================");
//        HealthCheckResponseDto healthCheckResponseDto = helloClient.healthCheck();
//        System.out.println(healthCheckResponseDto);
//        System.out.println("==============================");
//    }
//}

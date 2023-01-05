package com.app.api.health.controller;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.health.dto.HealthCheckResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class HealthCheckController {
    private final Environment environment;

    @GetMapping("/health")
    public ResponseEntity<HealthCheckResponseDto> healthCheck(WebRequest request){

        HealthCheckResponseDto healthCheckResponseDto =
            HealthCheckResponseDto.builder()
            .health("ok")
            .activeProfiles(Arrays.asList(environment.getActiveProfiles()))
            .build();
        return ResponseEntity.ok(healthCheckResponseDto);
    }    
}


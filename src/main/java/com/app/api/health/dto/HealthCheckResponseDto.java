package com.app.api.health.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import org.springframework.core.env.Environment;

@Getter @Builder
public class HealthCheckResponseDto {
    private String health;
    private List<String> activeProfiles;
}

package com.app.api.exceptiontest;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class BindExceptionDto {
    @NotBlank(message = "해당값은 필수입니다.")
    private String value1;

    @Max(value = 10, message = "최대 입력값은 10입니다.")
    private Integer value2;
}

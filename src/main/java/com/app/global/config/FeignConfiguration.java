package com.app.global.config;

import com.app.global.error.FeignClientExceptionErrorDecoder;
import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = {"com.app"})
@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    ErrorDecoder errorDecoder(){
        return new FeignClientExceptionErrorDecoder();
    }

    @Bean
    public Retryer retryer(){
        //실행주기,   ? ,  최대 몇번의 재시도를 진행할지
        return new Retryer.Default(1000, 2000, 3);
    }
}

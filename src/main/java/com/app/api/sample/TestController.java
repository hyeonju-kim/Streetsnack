package com.app.api.sample;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//version 처리
@RestController
@RequestMapping("/test")
public class TestController {
    
    @GetMapping(path = "/hello", produces = {"application/com.kbank.app-v1+json"} )
    public Map<String,String> hello1(){
        return Collections.singletonMap("version", "1.0");
    }

    @GetMapping(path = "/hello", produces = {"application/com.kbank.app-v2+json"})
    public Map<String,String> hello2(){
        return Collections.singletonMap("version", "1.1");
    }
     
}

package com.app.api.exceptiontest;


import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/exception")
public class ExceptionTestController {
    @GetMapping("/bind-exception-test")
    public String bindExceptionTest(@Valid BindExceptionDto bindExceptionDto){
        return "OK";
    }

    @GetMapping("/type-exception-test")
    public String bindExceptionTest(TestEnum testEnum){
        return "OK";
    }
    @PostMapping("/bind-exception-test")
    public String bindExceptionTestJson(@Valid @RequestBody BindExceptionDto bindExceptionDto){
        return "OK";
    }




}

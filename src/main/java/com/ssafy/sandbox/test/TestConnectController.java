package com.ssafy.sandbox.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConnectController {

    @GetMapping("/test")
    public String testConnect(){
        return "test Msgs";
    }

}

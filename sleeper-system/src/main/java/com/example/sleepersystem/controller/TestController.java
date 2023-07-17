package com.example.sleepersystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author zhouxz
 * @date 2023/7/16 16:22
 * @description
 */
@RestController
public class TestController {
    @GetMapping("info")
    public String test(){
        return "sleeper-system";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String hello(){
        return "feign test";
    }
}

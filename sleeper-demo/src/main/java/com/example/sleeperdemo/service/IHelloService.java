package com.example.sleeperdemo.service;

import com.example.sleepercommon.entity.ServerConstant;
import com.example.sleeperdemo.service.impl.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = ServerConstant.SLEEPER_SYSTEM, contextId = "helloServiceClient", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {
    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}

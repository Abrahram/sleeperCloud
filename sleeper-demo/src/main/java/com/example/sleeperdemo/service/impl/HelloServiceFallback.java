package com.example.sleeperdemo.service.impl;

import com.example.sleeperdemo.service.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhouxz
 * @date 2023/7/16 16:15
 * @description
 */
@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IHelloService> {
    @Override
    public IHelloService create(Throwable throwable) {
        return name -> {
            log.error("调用sleeper-system服务出错", throwable);
            return "调用出错";
        };
    }
}

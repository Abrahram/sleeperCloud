package com.example.sleeperdemo;

import com.example.sleepercommon.annotation.CommonCloudApplication;
import com.example.sleepercommon.annotation.EnableSleeperAuthExceptionHandler;
import com.example.sleepercommon.annotation.EnableSleeperOauth2FeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@CommonCloudApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SleeperDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleeperDemoApplication.class, args);
    }

}

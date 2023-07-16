package com.example.sleepersystem;

import com.example.sleepercommon.annotation.CommonCloudApplication;
import com.example.sleepercommon.annotation.EnableSleeperAuthExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableDiscoveryClient
@SpringBootApplication
@CommonCloudApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SleeperSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleeperSystemApplication.class, args);
    }

}

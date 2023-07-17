package com.example.sleeperserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SleeperRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleeperRegisterApplication.class, args);
    }

}

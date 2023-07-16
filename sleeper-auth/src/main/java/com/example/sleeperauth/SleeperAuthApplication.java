package com.example.sleeperauth;

import com.example.sleepercommon.annotation.CommonCloudApplication;
import com.example.sleepercommon.annotation.EnableSleeperAuthExceptionHandler;
import com.example.sleepercommon.annotation.EnableSleeperLettuceRedis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@CommonCloudApplication
@EnableSleeperLettuceRedis
@EnableSleeperAuthExceptionHandler
@MapperScan("com.example.sleeperauth.mapper")
public class SleeperAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleeperAuthApplication.class, args);
    }

}

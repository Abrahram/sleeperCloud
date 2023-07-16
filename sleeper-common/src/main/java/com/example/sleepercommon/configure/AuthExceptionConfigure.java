package com.example.sleepercommon.configure;

import com.example.sleepercommon.handler.SleeperAccessDeniedHandler;
import com.example.sleepercommon.handler.SleeperAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author zhouxz
 * @date 2023/7/15 22:32
 * @description
 */
public class AuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public SleeperAccessDeniedHandler accessDeniedHandler(){
        return new SleeperAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authenticationEntryPoint")
    public SleeperAuthExceptionEntryPoint authExceptionEntryPoint(){
        return new SleeperAuthExceptionEntryPoint();
    }
}

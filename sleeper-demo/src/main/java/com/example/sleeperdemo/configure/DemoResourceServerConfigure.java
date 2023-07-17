package com.example.sleeperdemo.configure;

import com.example.sleepercommon.handler.SleeperAccessDeniedHandler;
import com.example.sleepercommon.handler.SleeperAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author zhouxz
 * @date 2023/7/15 21:46
 * @description
 */
@Configuration
@EnableResourceServer
public class DemoResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private SleeperAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private SleeperAccessDeniedHandler accessDeniedHandler;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }
}

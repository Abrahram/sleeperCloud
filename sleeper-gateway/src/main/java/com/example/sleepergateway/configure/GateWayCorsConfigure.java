package com.example.sleepergateway.configure;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


/**
 * @author zhouxz
 * @date 2023/7/16 17:19
 * @description 跨域处理
 */
@Configuration
public class GateWayCorsConfigure {
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true); //允许cookie跨域
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL); //请求头部允许携带任何内容
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL); //允许任何来源
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL); //允许任何HTTP方法
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}

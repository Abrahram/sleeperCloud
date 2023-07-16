package com.example.sleeperauth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhouxz
 * @date 2023/7/15 21:52
 * @description
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:sleeper-auth.properties"})
@ConfigurationProperties(prefix = "sleeper.auth")
public class AuthProperties {
    private ClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    // 免认证路径
    private String anonUrl;

    //验证码配置类
    private ValidateCodeProperties code = new ValidateCodeProperties();

}

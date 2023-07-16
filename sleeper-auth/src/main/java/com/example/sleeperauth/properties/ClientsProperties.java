package com.example.sleeperauth.properties;

import lombok.Data;

/**
 * @author zhouxz
 * @date 2023/7/15 21:51
 * @description
 */
@Data
public class ClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}

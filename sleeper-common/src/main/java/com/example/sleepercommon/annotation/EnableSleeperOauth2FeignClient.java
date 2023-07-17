package com.example.sleepercommon.annotation;

import com.example.sleepercommon.configure.SleeperOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhouxz
 * @date 2023/7/16 16:30
 * @description 开启带令牌的Feign请求，避免微服务内部调用出现401异常
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(value = SleeperOAuth2FeignConfigure.class)
public @interface EnableSleeperOauth2FeignClient {
}

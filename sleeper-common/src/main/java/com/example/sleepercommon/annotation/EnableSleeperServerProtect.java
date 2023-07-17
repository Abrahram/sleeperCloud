package com.example.sleepercommon.annotation;

import com.example.sleepercommon.configure.ServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhouxz
 * @date 2023/7/16 16:30
 * @description 开启微服务防护，避免客户端绕过网关直接请求微服务
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerProtectConfigure.class)
public @interface EnableSleeperServerProtect {
}

package com.example.sleepercommon.annotation;

import com.example.sleepercommon.configure.AuthExceptionConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhouxz
 * @date 2023/7/16 16:30
 * @description 认证类型异常翻译
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AuthExceptionConfigure.class)
public @interface EnableSleeperAuthExceptionHandler {

}

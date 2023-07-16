package com.example.sleepercommon.annotation;

import com.example.sleepercommon.configure.LettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LettuceRedisConfigure.class)
public @interface EnableSleeperLettuceRedis {
}

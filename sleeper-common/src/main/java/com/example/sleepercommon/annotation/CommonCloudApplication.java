package com.example.sleepercommon.annotation;

import com.example.sleepercommon.selector.CloudApplicationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CloudApplicationSelector.class)
public @interface CommonCloudApplication {
}

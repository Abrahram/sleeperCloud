package com.example.sleepercommon.selector;

import com.example.sleepercommon.configure.AuthExceptionConfigure;
import com.example.sleepercommon.configure.ServerProtectConfigure;
import com.example.sleepercommon.configure.SleeperOAuth2FeignConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhouxz
 * @date 2023/7/16 16:55
 * @description
 */
public class CloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                AuthExceptionConfigure.class.getName(),
                ServerProtectConfigure.class.getName(),
                SleeperOAuth2FeignConfigure.class.getName()
        };
    }
}

package com.example.sleepercommon.handler;

import com.example.sleepercommon.entity.SleeperResponse;
import com.example.sleepercommon.exception.SleeperAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;


/**
 * @author zhouxz
 * @date 2023/7/15 22:56
 * @description 全局异常处理
 */
@Slf4j
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SleeperResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new SleeperResponse().message("系统内部异常");
    }

    @ExceptionHandler(value = SleeperAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SleeperResponse handleFebsAuthException(SleeperAuthException e) {
        log.error("系统错误", e);
        return new SleeperResponse().message(e.getMessage());
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public SleeperResponse handleAccessDeniedException(){
        return new SleeperResponse().message("没有权限访问该资源");
    }
}

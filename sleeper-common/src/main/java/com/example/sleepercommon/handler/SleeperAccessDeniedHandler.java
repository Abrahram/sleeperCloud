package com.example.sleepercommon.handler;

import com.example.sleepercommon.entity.SleeperResponse;
import com.example.sleepercommon.utils.SleeperUtils;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouxz
 * @date 2023/7/15 22:29
 * @description 处理403类型异常
 */
public class SleeperAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        SleeperResponse febsResponse = new SleeperResponse();
        SleeperUtils.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_FORBIDDEN, febsResponse.message("没有权限访问该资源"));
    }
}

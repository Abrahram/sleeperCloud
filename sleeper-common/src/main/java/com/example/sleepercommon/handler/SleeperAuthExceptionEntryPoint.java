package com.example.sleepercommon.handler;

import com.example.sleepercommon.entity.SleeperResponse;
import com.example.sleepercommon.utils.SleeperUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouxz
 * @date 2023/7/15 22:23
 * @description 资源服务器异常处理
 */
public class SleeperAuthExceptionEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        SleeperResponse sleeperResponse = new SleeperResponse();

        SleeperUtils.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, sleeperResponse.message("token无效")
        );
    }
}

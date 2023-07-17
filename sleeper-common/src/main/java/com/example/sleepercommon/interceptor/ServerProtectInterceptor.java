package com.example.sleepercommon.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.sleepercommon.entity.BaseConstant;
import com.example.sleepercommon.entity.SleeperResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouxz
 * @date 2023/7/16 16:43
 * @description
 */
public class ServerProtectInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException, IOException {
        // 从请求头中获取 Zuul Token
        String token = request.getHeader(BaseConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.encode(BaseConstant.ZUUL_TOKEN_VALUE.getBytes()));
        // 校验 Zuul Token的正确性
        if (StringUtils.equals(zuulToken, token)) {
            return true;
        } else {
            SleeperResponse sleeperResponse = new SleeperResponse();
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write(JSONObject.toJSONString(sleeperResponse.message("请通过网关获取资源")));
            return false;
        }
    }
}

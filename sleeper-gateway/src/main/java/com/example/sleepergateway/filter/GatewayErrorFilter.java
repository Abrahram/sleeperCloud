package com.example.sleepergateway.filter;

import com.example.sleepercommon.entity.SleeperResponse;
import com.example.sleepercommon.utils.SleeperUtils;
import com.netflix.zuul.context.RequestContext;
import io.lettuce.core.dynamic.support.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhouxz
 * @date 2023/7/15 22:52
 * @description Zuul报错处理
 */
@Slf4j
@Component
public class GatewayErrorFilter extends SendErrorFilter {
    @Override
    public Object run() {
        try {
            SleeperResponse febsResponse = new SleeperResponse();
            RequestContext ctx = RequestContext.getCurrentContext();
            String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);

            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            String errorCause = exception.getErrorCause();
            Throwable throwable = exception.getThrowable();
            String message = throwable.getMessage();
            message = StringUtils.isBlank(message) ? errorCause : message;
            febsResponse = resolveExceptionMessage(message, serviceId, febsResponse);

            HttpServletResponse response = ctx.getResponse();
            SleeperUtils.makeResponse(
                    response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR, febsResponse
            );
            log.error("Zull sendError：{}", febsResponse.getMessage());
        } catch (Exception ex) {
            log.error("Zuul sendError", ex);
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }

    private SleeperResponse resolveExceptionMessage(String message, String serviceId, SleeperResponse febsResponse) {
        if (StringUtils.containsIgnoreCase(message, "time out")) {
            return febsResponse.message("请求" + serviceId + "服务超时");
        }
        if (StringUtils.containsIgnoreCase(message, "forwarding error")) {
            return febsResponse.message(serviceId + "服务不可用");
        }
        return febsResponse.message("Zuul请求" + serviceId + "服务异常");
    }
}

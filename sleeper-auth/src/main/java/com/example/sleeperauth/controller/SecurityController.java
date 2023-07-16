package com.example.sleeperauth.controller;

import com.example.sleeperauth.service.ValidateCodeService;
import com.example.sleepercommon.entity.SleeperResponse;
import com.example.sleepercommon.exception.SleeperAuthException;
import com.example.sleepercommon.exception.ValidateCodeException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author zhouxz
 * @date 2023/7/15 16:45
 * @description
 */
@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @DeleteMapping("signout")
    public SleeperResponse signout(HttpServletRequest request) throws SleeperAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ", "");
        SleeperResponse sleeperResponse = new SleeperResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new SleeperAuthException("退出登录失败");
        }
        return sleeperResponse.message("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }
}

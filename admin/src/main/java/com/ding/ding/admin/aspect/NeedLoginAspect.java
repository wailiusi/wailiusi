package com.ding.ding.admin.aspect;

import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class NeedLoginAspect {

    private static final String LOGIN_TOKEN_KEY = "X-Litemall-Token";

    @Pointcut("@annotation(com.ding.ding.admin.annotation.NeedLogin)")
    @SuppressWarnings("EmptyMethod")
    public void pointCut() {
    }


    @Before("pointCut()")
    public void doBefore() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(LOGIN_TOKEN_KEY);
        if (StringUtil.isEmpty(token)) {
            throw new RuntimeException("请先登录");
        }
    }
}


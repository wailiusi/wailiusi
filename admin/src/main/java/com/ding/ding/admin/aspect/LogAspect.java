package com.ding.ding.admin.aspect;

import cn.hutool.core.util.ArrayUtil;
import com.ding.ding.common.util.IpUtil;
import com.ding.ding.db.domain.SysLog;
import com.ding.ding.db.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    //定义切点
    @Pointcut("execution(* com.ding.ding.admin.web.*.*.*(..))")
    public void log() {
    }

    //记录入参参数
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        //url
        log.info("------------------------调用方法开始：{} ------------------------", httpServletRequest.getRequestURL());

        //method
        log.info("method方法={}", httpServletRequest.getMethod());

        //类方法地址
        log.info("class_method类方法地址={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数列表
        log.info("args参数={}", joinPoint.getArgs());
        SysLog sysLog = new SysLog();

        String ip = IpUtil.getIpAddr(httpServletRequest);
        sysLog.setIp(ip);
        sysLog.setAction(httpServletRequest.getRequestURL().toString());
        sysLog.setParams(ArrayUtil.toString(joinPoint.getArgs()));
        sysLogService.save(sysLog);

    }

    //记录返回值
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        if (object != null) {
            log.info("response返回值={}", object.toString());
            log.info("------------------------调用方法结束：------------------------");
        }
    }

}

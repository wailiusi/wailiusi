package com.ding.ding.admin.web;

import com.ding.ding.common.util.IpUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 获取request中的用户对象ID
     *
     * @return
     */
    protected String getIp() {
        String ip = IpUtil.getIpAddr(getRequest());
        return ip;
    }

}

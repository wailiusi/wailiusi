package com.ding.ding.admin.web.v1;

import com.ding.ding.admin.dto.admin.AdminLogin;
import com.ding.ding.common.util.IpUtil;
import com.ding.ding.db.domain.SysAdmin;
import com.ding.ding.db.enums.CoreExceptionEnum;
import com.ding.ding.db.exception.ServiceException;
import com.ding.ding.db.service.SysAdminService;
import com.ding.ding.db.vo.response.ResponseResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;

public class AdminAuthController {

    @Autowired
    private SysAdminService adminService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody @Valid AdminLogin admin, HttpServletRequest request) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(new UsernamePasswordToken(username, password));
        } catch (Exception e) {
            throw new ServiceException(CoreExceptionEnum.ADMIN_INVALID_ACCOUNT);
        }
        currentUser = SecurityUtils.getSubject();
        SysAdmin adminUser = (SysAdmin) currentUser.getPrincipal();
        adminUser.setLastLoginIp(IpUtil.getIpAddr(request));
        adminUser.setLastLoginTime(LocalDateTime.now());
        adminService.save(adminUser);
        return ResponseResult.success(currentUser.getSession().getId());
    }


}

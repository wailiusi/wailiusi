package com.ding.ding.admin.web;

import com.ding.ding.common.util.StringUtils;
import com.ding.ding.db.domain.SysAdmin;
import com.ding.ding.db.enums.CoreExceptionEnum;
import com.ding.ding.db.exception.ServiceException;
import com.ding.ding.db.vo.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/shiro")
@Slf4j
public class ShiroController extends BaseController {

    @GetMapping("/401")
    public ResponseResult page401() {
        throw new UnauthenticatedException();
    }

    @GetMapping("/403")
    public ResponseResult page403() {
        throw new UnauthorizedException();
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody Map<String, String> map) {
        log.info("用户登录, body:{}", map);
        String uname = map.get("uname");
        String pwd = map.get("pwd");

        if (StringUtils.isEmpty(uname)) {
            throw new ServiceException(CoreExceptionEnum.PARAMETER_VERIFICATION_FAILED);
        }
        if (StringUtils.isEmpty(pwd)) {
            throw new ServiceException(CoreExceptionEnum.PARAMETER_VERIFICATION_FAILED);
        }

        Subject currentUser = SecurityUtils.getSubject();
        try {
            //登录
            currentUser.login(new UsernamePasswordToken(uname, pwd));
            //从session取出用户信息
            SysAdmin user = (SysAdmin) currentUser.getPrincipal();
            if (user == null) {
                throw new AuthenticationException();
            }
            //返回登录用户的信息给前台，含用户的所有角色和权限
            return ResponseResult.success("登陆成功");
        } catch (UnknownAccountException uae) {
            return ResponseResult.error("用户帐号不正确");
        } catch (IncorrectCredentialsException ice) {
            return ResponseResult.error("用户密码不正确");
        } catch (LockedAccountException lae) {
            return ResponseResult.error("用户帐号被锁定");
        } catch (AuthenticationException ae) {
            return ResponseResult.error("登录出错");
        }
    }
}
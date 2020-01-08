package com.ding.ding.admin.web.v1;

import cn.hutool.core.convert.Convert;
import com.ding.ding.admin.annotation.RequiresPermissionsDesc;
import com.ding.ding.admin.dto.admin.AdminLogin;
import com.ding.ding.admin.web.BaseController;
import com.ding.ding.common.util.bcrypt.BCryptPasswordEncoder;
import com.ding.ding.db.domain.SysAdmin;
import com.ding.ding.db.enums.CoreExceptionEnum;
import com.ding.ding.db.exception.ServiceException;
import com.ding.ding.db.service.SysAdminService;
import com.ding.ding.db.vo.response.ResponseResult;
import com.ding.ding.db.vo.response.admin.admin.SysAdminVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin/admin")
@Slf4j
@Api(value = "管理员管理", description = "管理员管理")
public class AdminAdminController extends BaseController {

    @Autowired
    private SysAdminService adminService;

    @ApiOperation(value = "添加")
    @RequiresPermissions("admin:admin:create")
    @RequiresPermissionsDesc(menu = {"系统管理", "管理员"}, button = "添加")
    @PostMapping("/create")
    public ResponseResult<SysAdminVo> create(@RequestBody @Valid AdminLogin admin) {
        //验证

        String username = admin.getUsername();
        List<SysAdmin> adminList = adminService.findAdmin(username);
        if (adminList.size() > 0) {
            throw new ServiceException(CoreExceptionEnum.ADMIN_IS_HAVE);
        }
        String rawPassword = admin.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setPassword(encodedPassword);
        sysAdmin.setUsername(username);
        sysAdmin.setAvatar(admin.getAvatar());
        adminService.save(sysAdmin);
        SysAdminVo sysAdminVo = Convert.convert(SysAdminVo.class, sysAdmin);
        return ResponseResult.success(sysAdminVo);
    }


}

package com.ding.ding.admin.web.v1;

import com.ding.ding.admin.web.BaseController;
import com.ding.ding.db.enums.CoreExceptionEnum;
import com.ding.ding.db.exception.ServiceException;
import com.ding.ding.db.service.UserService;
import com.ding.ding.db.vo.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/demo")
@Api(value = "demo服务", description = "demo服务")
public class DemoController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "hello")
    @PostMapping("hello")
    public ResponseResult hello(@RequestBody Map string) {
        return ResponseResult.success(userService.count());
    }

    @ApiOperation(value = "hello")
    @GetMapping("hello")
    public ResponseResult hello(String string) {
        return ResponseResult.success(userService.count());
    }

    @ApiOperation(value = "error")
    @GetMapping("error")
    public ResponseResult error() {
        System.out.println("error ----------");
        throw new ServiceException(CoreExceptionEnum.DELECT_FAILED);
    }

}

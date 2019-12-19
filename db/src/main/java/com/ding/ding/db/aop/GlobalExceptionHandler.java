package com.ding.ding.db.aop;

import com.ding.ding.db.enums.CoreExceptionEnum;
import com.ding.ding.db.enums.ExceptionConstant;
import com.ding.ding.db.vo.response.ResponseResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.ding.ding.db.enums.CoreExceptionEnum.THERE_ARE_DUPLICATE_PARAMETERS_IN_THE_DATABASE;


@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 参数验证失败
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResult handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        List<FieldError> list = e.getBindingResult().getFieldErrors();
        String message = CollectionUtils.isEmpty(list) || StringUtils.isEmpty(list.get(0).getDefaultMessage()) ? "参数值不能为空" : list.get(0).getDefaultMessage();
        log.error("param not valid,url:{},exception:{}", request.getRequestURI(), message);
        return ResponseResult.error(CoreExceptionEnum.PARAMETER_VERIFICATION_FAILED);

    }

    @ExceptionHandler(ShiroException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseResult handleShiroException(ShiroException e) {
        String eName = e.getClass().getSimpleName();
        log.error("shiro执行出错：{}", eName);
        return ResponseResult.error(CoreExceptionEnum.USER_SHIRO_ERROR);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseResult page401(UnauthenticatedException e) {
        log.error("未经授权:{}", e.getMessage());
        return ResponseResult.error(CoreExceptionEnum.USER_UNAUTHENTICATED);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseResult page403(UnauthorizedException e) {
        log.error("无权限访问:{}", e.getMessage());
        return ResponseResult.error(CoreExceptionEnum.USER_UNAUTHORIZED);
    }

    /**
     * 拦截其他异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseResult system(Exception e) {
        log.error("运行时异常:", e);
        //重复键异常
        if (ExceptionConstant.DUPLICATE_KEY_EXCEPTION.equals(e.getClass().getName())) {
            return ResponseResult.error(THERE_ARE_DUPLICATE_PARAMETERS_IN_THE_DATABASE.getCode(), THERE_ARE_DUPLICATE_PARAMETERS_IN_THE_DATABASE.getMessage());
        }
        //參數校验错误
        if (ExceptionConstant.BIND_EXCEPTION.equals(e.getClass().getName())) {
            return ResponseResult.error(500, ((BindException) e).getAllErrors().get(0).getDefaultMessage());
        }
        //拦截自定义校验错误
        if (ExceptionConstant.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.equals(e.getClass().getName())) {
            return ResponseResult.error(500, "",
                    ((MethodArgumentNotValidException) e).getMessage().substring(((MethodArgumentNotValidException) e)
                            .getMessage().lastIndexOf("[") + 1, e.getMessage().lastIndexOf("]") - 1));
        }
        return ResponseResult.error(e.getMessage());
    }
}

package com.ding.ding.db.enums;

/**
 * @Author: wy
 * @Date: Created in 1:07 2019/8/11
 * @Description:
 * @Modified: By：
 */
public class ExceptionConstant {

    /**
     * 重复键异常
     */
    public static final String DUPLICATE_KEY_EXCEPTION = "org.springframework.dao.DuplicateKeyException";
    /**
     * 參數校验错误
     */
    public static final String BIND_EXCEPTION = "org.springframework.validation.BindException";
    /**
     * 自定义參數校验错误
     */
    public static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION = "org.springframework.web.bind.MethodArgumentNotValidException";

    ExceptionConstant() {

    }
}

package com.ding.ding.db.vo.response;

import com.ding.ding.db.enums.AbstractBaseExceptionEnum;
import lombok.Data;

@Data
public class ErrorResponseResult<T> extends ResponseResult<T> {

    public ErrorResponseResult(String message) {
        super(DEFAULT_ERROR_CODE, GENERAL_FAILURE_CODE, message, null);
    }

    public ErrorResponseResult(Integer code, String message) {
        super(code, GENERAL_FAILURE_MESSAGE, message, null);
    }

    public ErrorResponseResult(AbstractBaseExceptionEnum exceptionEnum) {
        super(exceptionEnum.getCode(), GENERAL_FAILURE_MESSAGE, exceptionEnum.getMessage(), null);
    }

    public ErrorResponseResult(Integer code, String message, String error) {
        super(code, error, message, null);
    }
}

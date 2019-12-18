package com.ding.ding.db.util;

import com.ding.ding.db.exception.ServiceException;
import com.ding.ding.db.vo.response.ResponseResult;

public class ServiceExceptionUtil {
    public static ResponseResult toResponse(Exception e, String defaultCode) {
        if (e instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) e;
            return ResponseResult.error(400, serviceException.getCode().toString(), serviceException.getErrorMessage());
        } else {
            return ResponseResult.error(defaultCode);
        }
    }
}

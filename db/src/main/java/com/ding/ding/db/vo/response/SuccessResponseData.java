package com.ding.ding.db.vo.response;

/**
 * @author suntengteng
 * @date 2019/7/8 21:07
 */
public class SuccessResponseData<T> extends ResponseResult<T> {

    public SuccessResponseData() {
        super(DEFAULT_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, GENERAL_SUCCESS_MESSAGE, null);
    }

    public SuccessResponseData(T t) {
        super(DEFAULT_SUCCESS_CODE, GENERAL_SUCCESS_MESSAGE, GENERAL_SUCCESS_MESSAGE, t);
    }

    public SuccessResponseData(Integer code, String message, T object) {
        super(code, message, null, object);
    }
}

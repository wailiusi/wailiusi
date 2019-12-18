package com.ding.ding.db.vo.response;

import com.ding.ding.db.enums.AbstractBaseExceptionEnum;
import com.ding.ding.db.enums.CoreExceptionEnum;
import com.ding.ding.db.enums.ResultStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author : MrFox
 * @modify : wy
 * @create_date : 2019-07-07 16:22
 * @version: : v1.0
 * @update_date :
 * @update_by :
 * 响应实体类
 **/
@Data
@ApiModel(description = "响应")
public class ResponseResult<T> {

    public static final String GENERAL_SUCCESS_CODE = "maskit.success.general";
    public static final String GENERAL_SUCCESS_MESSAGE = "Maskit general success";
    public static final String GENERAL_FAILURE_CODE = "maskit.failure.general";
    public static final String GENERAL_FAILURE_MESSAGE = "Maskit general failure";
    public static final int GENERAL_SUCCESS_STATUS = 200;
    public static final int GENERAL_FAILURE_STATUS = 400;

    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";

    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";

    public static final Integer DEFAULT_SUCCESS_CODE = 200;

    public static final Integer DEFAULT_ERROR_CODE = 500;


    @ApiModelProperty(value = "响应状态")
    private Integer status;

    @ApiModelProperty(value = "错误位置")
    private String error;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "时间戳")
    private long timestamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

    @ApiModelProperty(value = "请求路径")
    private String path;

    @ApiModelProperty(value = "响应数据")
    private T data;

    {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        path = attributes.getRequest().getRequestURL().toString();
    }

    public ResponseResult(Integer status, String error, String message, T data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public ResponseResult() {
    }

    public ResponseResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseResult(AbstractBaseExceptionEnum exceptionEnum) {
        this.status = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }

    public static SuccessResponseData success() {
        return new SuccessResponseData();
    }

    public static <T> SuccessResponseData<T> success(T t) {
        return new SuccessResponseData<>(t);
    }

    public static <T> SuccessResponseData success(Integer code, String message, T t) {
        return new SuccessResponseData<>(code, message, t);
    }

    public static ErrorResponseResult error(String message) {
        return new ErrorResponseResult(message);
    }

    public static ErrorResponseResult error(Integer code, String message) {
        return new ErrorResponseResult(code, message);
    }

    public static <T> ErrorResponseResult error(Integer code, String error, String message) {
        return new ErrorResponseResult<>(code, message, error);
    }

    public static ErrorResponseResult error(CoreExceptionEnum ex) {
        return new ErrorResponseResult<>(ex.getCode(), ex.getError(), ex.getMessage());
    }

    public Integer getStatus() {
        return this.status;
    }

    public ResponseResult setStatus(ResultStatus resultStatus) {
        this.status = resultStatus.getStatus();
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ResponseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public ResponseResult setData(T data) {
        this.data = data;
        return this;
    }
}
package com.ding.ding.db.enums;


public enum CoreExceptionEnum implements AbstractBaseExceptionEnum {

    /*    http状态返回代码 4xx（请求错误）   ***************************/
    SERVER_ERROR(500, "dingding.server.error", "服务器异常"),
    THERE_ARE_DUPLICATE_PARAMETERS_IN_THE_DATABASE(501, "dingding.mysql.data.repeat", "数据库重复"),
    UPDATE_FAILED(502, "dingding.update.error", "更新失败"),
    SELECT_FAILED(503, "dingding.select.error", "查询失败"),
    INSERT_FAILED(504, "dingding.save.error", "保存失败"),

    PARAMETER_VERIFICATION_FAILED(420, "dingding.param.error", "参数不合法"),
    ADMIN_IS_HAVE(421, "dingding.admin.name.have", "管理员姓名已存在"),
    USER_UNAUTHORIZED(423, "dingding.no.have.privilege", "无权访问"),
    USER_UNAUTHENTICATED(424, "dingding.login.error", "未授权"),
    USER_SHIRO_ERROR(425, "dingding.shiro.error", "SHIRO运行出错"),
    ADMIN_INVALID_ACCOUNT(426,"admin.invalid.account","账号或密码错误"),
    DELECT_FAILED(499, "dingding.delete.error", "删除失败");

    private Integer code;
    private String error;
    private String message;


    CoreExceptionEnum(int code, String error, String message) {
        this.code = code;
        this.error = error;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

}

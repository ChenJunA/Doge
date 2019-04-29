package com.doge.enums;

/**
 * @Description: 错误状态码枚举类
 * @Author: chenjun
 * @Date: 2018/12/3 14:13
 */
public enum StatusCode {
    /**
     * 请求成功
     */
    SUCCESS_CODE(200, "SUCCESS"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(500, "系统错误"),

    /**
     * 参数校验错误
     */
    PARAMETER_CHECK_ERROR(400, "参数校验错误"),

    /**
     * 用户权限不足
     */
    AUTH_VALID_ERROR(701, "用户权限不足"),

    /**
     * 用户未登录或登录状态超时失效
     */
    UNLOGIN_ERROR(401, "用户未登录或登录状态超时失效"),

    /**
     * 请求内容不存在
     */
    CONTENT_ERROR(233, "请求内容不存在"),

    /**
     * 邮箱已被注册
     */
    EMAIL_USEED(10001, "邮箱已被注册"),

    /**
     * 用户不存在
     */
    USERNAME_ERROR(10002, "用户不存在"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR(10003, "密码错误"),

    /**
     * 文件为空
     */
    FILE_EMPTY(10004, "文件为空"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(10000, "未知错误");

    private Integer code;
    private String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static StatusCode getByCode(Integer code) {
        for (StatusCode statusCode : values()) {
            if (statusCode.getCode() == code) {
                return statusCode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

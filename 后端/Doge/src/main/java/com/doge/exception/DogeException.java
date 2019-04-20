package com.doge.exception;

import com.doge.enums.StatusCode;

/**
 * @Description: 自定义异常类
 * @Author: chenjun
 * @Date: 2018/04/12
 */
public class DogeException extends RuntimeException {
    /**
     * 状态码
     */
    private Integer code;

    public DogeException(StatusCode statusCode) {
        super(statusCode.getMessage());
        this.code = statusCode.getCode();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

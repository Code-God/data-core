package com.jsure.core.exception;

import lombok.Getter;

/**
 * @Author: wuxiaobiao
 * @Description: 自定义异常
 * @Date: Created in 2018/4/8
 * @Time: 18:01
 * I am a Code Man -_-!
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -3320578247182194189L;

    @Getter
    private String code;

    public CustomException(String code) {
        this.code = code;
    }

    public CustomException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public CustomException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

}

package me.lyc8503.spring.starter.incantation.exception;

import lombok.Getter;

public class BizException extends RuntimeException {
    @Getter
    private final int code;
    @Getter
    private final String message;
    @Getter
    private final int httpCode;

    public BizException(ErrorType type) {
        this.code = type.getCode();
        this.message = type.getMessage();
        this.httpCode = type.getHttpCode();
    }

    public BizException(ErrorType type, String msg) {
        this.code = type.getCode();
        this.message = msg;
        this.httpCode = type.getHttpCode();
    }

}

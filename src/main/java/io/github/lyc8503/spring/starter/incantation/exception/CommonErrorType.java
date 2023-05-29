package io.github.lyc8503.spring.starter.incantation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonErrorType implements ErrorType {
    UNKNOWN_ERROR(100000, "Unknown Error", 500),
    BAD_REQUEST(100001, "Bad Request", 400),
    ILLEGAL_ARGUMENTS(100002, "Illegal Arguments", 400),
    UNAUTHORIZED(100003, "Unauthorized", 401),
    FORBIDDEN(100004, "Forbidden", 403),
    NOT_FOUND(100005, "Not Found", 404);

    private final int code;
    private final String message;
    private final int httpCode;
}

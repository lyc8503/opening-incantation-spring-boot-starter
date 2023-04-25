package io.github.lyc8503.spring.starter.incantation.controller;

import lombok.extern.slf4j.Slf4j;
import io.github.lyc8503.spring.starter.incantation.exception.BizException;
import io.github.lyc8503.spring.starter.incantation.exception.CommonErrorType;
import io.github.lyc8503.spring.starter.incantation.pojo.CommonResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * global catch
     */

    @ExceptionHandler(BizException.class)
    public CommonResponse<?> handleBaseException(BizException e) {
        log.error("Biz Exception", e);
        return CommonResponse.error(e);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpMediaTypeException.class, MissingServletRequestParameterException.class})
    public CommonResponse<?> handleBadRequest(Exception e) {
        log.error("Bad Request Exception", e);
        return CommonResponse.error(CommonErrorType.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Invalid Argument", e);
        return CommonResponse.error(CommonErrorType.ILLEGAL_ARGUMENTS, e.getAllErrors().get(0).getDefaultMessage());
//        return Response.error(ResponseType.ILLEGAL_ARGUMENTS, e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining("/")));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResponse<?> handleMethodNotSupportException(HttpRequestMethodNotSupportedException e) {
        log.error("Method Not Support Exception", e);
        return CommonResponse.error(CommonErrorType.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handleDefaultException(Exception e) {
        log.error("Global catch", e);
        return CommonResponse.error(CommonErrorType.UNKNOWN_ERROR);
    }
}

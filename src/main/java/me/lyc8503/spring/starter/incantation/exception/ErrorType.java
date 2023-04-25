package me.lyc8503.spring.starter.incantation.exception;

public interface ErrorType {
    int getCode();
    String getMessage();
    int getHttpCode();

}

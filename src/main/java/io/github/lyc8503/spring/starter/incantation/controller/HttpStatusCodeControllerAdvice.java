package io.github.lyc8503.spring.starter.incantation.controller;


import io.github.lyc8503.spring.starter.incantation.pojo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice
public class HttpStatusCodeControllerAdvice implements ResponseBodyAdvice<CommonResponse<?>> {
    /**
     * Used to set http status code
     */

    @Override
    public boolean supports(MethodParameter returnType, @NonNull Class converterType) {
        return returnType.getParameterType().isAssignableFrom(CommonResponse.class);
    }

    @Override
    public CommonResponse<?> beforeBodyWrite(CommonResponse<?> body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        if (body != null) {
            response.setStatusCode(HttpStatus.valueOf(body.getHttpCode()));
        }
        return body;
    }
}

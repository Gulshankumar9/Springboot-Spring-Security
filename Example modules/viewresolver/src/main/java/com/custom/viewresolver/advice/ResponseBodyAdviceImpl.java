package com.custom.viewresolver.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseBodyAdviceImpl implements ResponseBodyAdvice<Model> {

    public static Logger log = LogManager.getLogger(ResponseBodyAdviceImpl.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        log.info("This is supports from ResponseBodyAdviceImpl....");
        return true;
    }

    @Override
    public Model beforeBodyWrite(Model body, MethodParameter returnType, MediaType selectedContentType, Class<?
            extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                 ServerHttpResponse response) {

        log.info("This is beforeBodyWrite from ResponseBodyAdviceImpl....");
        return body;
    }
}
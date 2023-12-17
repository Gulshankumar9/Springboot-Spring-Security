package com.forward.forwarddemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CustomRequestWrapper extends HttpServletRequestWrapper {

    public CustomRequestWrapper(HttpServletRequest request) {

        super(request);
    }

    @Override
    public Object getAttribute(String name) {

        if ("param3".equals(name)) {
            return "value3";
        }
        if ("param4".equals(name)) {
            return "value4";
        }
        return super.getAttribute(name);
    }
}
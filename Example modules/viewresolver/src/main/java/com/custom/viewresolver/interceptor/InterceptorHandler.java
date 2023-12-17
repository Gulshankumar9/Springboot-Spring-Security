package com.custom.viewresolver.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;

@Component
public class InterceptorHandler implements HandlerInterceptor {

    public static Logger log = LogManager.getLogger(InterceptorHandler.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("PreHandle");

        long starttime = System.currentTimeMillis();

        request.setAttribute("startTime", starttime);

        log.info("In preHandle method");

        String name = request.getRequestURI();

        log.info(name);

        String data = request.getReader().lines().collect(Collectors.joining());

        log.info(data);

        /*if ( true ) {
            throw new ViewException("Exception raised in PreHandler method...");
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("PostHandle");

        log.info("In PostHandle method");

        String queryString = request.getQueryString() == null ? "" : "?" + request.getQueryString();

        String path = request.getRequestURI() + queryString;

        long startTime = (Long) request.getAttribute("startTime");

        long endTime = System.currentTimeMillis();

        log.info(String.format("%s millisecond taken to process the request %s . ", (endTime - startTime), path));

        boolean flag = false;

        /*if (flag) {

            throw new CustomException("Exception raised in postHandle", modelAndView);

        } else {

            throw new ViewException("Exception raised in postHandle", modelAndView);
        }*/

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

        System.out.println("AfterCompletion");
    }
}
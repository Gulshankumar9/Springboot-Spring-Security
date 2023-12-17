package com.custom.viewresolver.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForwardRedirectController {

    @PostMapping("/forwardFrom")
    public ModelAndView forwardFrom(@RequestBody RequestObject requestObject, ModelAndView modelAndView) {

        modelAndView.setViewName("forward");

        return modelAndView;
    }

    @GetMapping("/forwardTo")
    public ModelAndView forwardTo(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {

        httpServletRequest.getAttributeNames().asIterator().forEachRemaining(name -> {

            modelAndView.addObject(name, httpServletRequest.getAttribute(name));

        });

        modelAndView.setViewName("ftl");

        return modelAndView;
    }

    @GetMapping("/redirectFrom")
    public ModelAndView redirectFrom(ModelAndView modelAndView) {

        modelAndView.setViewName("redirect");

        return modelAndView;
    }

    @GetMapping("/redirectTo")
    public ModelAndView redirectTo(ModelAndView modelAndView, HttpServletRequest httpServletRequest) {

        httpServletRequest.getParameterNames().asIterator().forEachRemaining(name -> {

            modelAndView.addObject(name, httpServletRequest.getParameter(name));
        });
        modelAndView.setViewName("ftl");

        return modelAndView;
    }

}
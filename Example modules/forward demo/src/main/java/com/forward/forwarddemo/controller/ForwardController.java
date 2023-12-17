package com.forward.forwarddemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForwardController {

    @GetMapping("/forward")
    public ModelAndView forwardRequest(ModelAndView model, HttpServletRequest request) {
        request.setAttribute("param1", "value1");
        request.setAttribute("param2", "value2");
        model.setViewName("forward:/destination");
        return model;
    }

    @GetMapping("/destination")
    public ModelAndView destination(ModelAndView model, HttpServletRequest request) {
        String param1 = (String) request.getAttribute("param1");
        String param2 = (String) request.getAttribute("param2");
        model.addObject("queryparam1", param1);
        model.addObject("queryparam2", param2);
        model.setViewName("resultPage");
        return model;
    }
}
package com.custom.viewresolver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomController {

    /*@GetMapping(value = "/jsp")
    public ModelAndView jspcustom() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "JSP viewresolver");
        modelAndView.setViewName("custom");

        return modelAndView;
    }

    @GetMapping(value = "/ftlcustom")
    public ModelAndView ftlcustom() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "FTL viewresolver");
        modelAndView.setViewName("mark");

        return modelAndView;
    }

    //custom freemarker controller
    @GetMapping("/ftl")
    public ModelAndView hello(ModelAndView model) {

        model.addObject("message", "This is a message from the controller");
        model.setViewName("abc");
        return model;
    }*/

    /*@GetMapping("/customforward")
    public ModelAndView customForwardfreemarker(ModelAndView model, HttpServletRequest request) {

        request.setAttribute("param3", "def");
        request.setAttribute("param4", "456");

        model.setViewName("forward:destination");

        return model;

    }

    @GetMapping("/destination")
    public ModelAndView customForwardfreemarkerimpl(ModelAndView model, HttpServletRequest request) {

        String param1 = (String) request.getAttribute("param3");
        String param2 = (String) request.getAttribute("param4");

        model.addObject("queryparam3", param1);
        model.addObject("queryparam4", param2);

        model.setViewName("end");

        return model;*/

    @GetMapping("/customredirect")
    public ModelAndView customfreemarker(ModelAndView modelAndView, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute("queryparam1", "abc");
        redirectAttributes.addAttribute("queryparam2", "123");

        modelAndView.setViewName("apple");

        return modelAndView;
    }

    @GetMapping("/start")
    public ModelAndView customRedirectfreemarkerimpl(@RequestParam String queryparam1,
                                                     @RequestParam String queryparam2, ModelAndView modelAndView) {

        modelAndView.addObject("message", "resolved from custom freemarker");

        modelAndView.addObject("queryparam1", queryparam1);
        modelAndView.addObject("queryparam2", queryparam2);

        modelAndView.setViewName("start");

        return modelAndView;

    }

}
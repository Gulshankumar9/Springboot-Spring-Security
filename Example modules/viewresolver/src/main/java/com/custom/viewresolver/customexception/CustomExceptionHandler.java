package com.custom.viewresolver.customexception;

import com.custom.viewresolver.views.ViewResolverImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ModelAndView handleCustomException(CustomException ex) {

        ModelAndView model = ex.getModelAndView();
        //ModelAndView model =new ModelAndView("customError.jsp");

        //model.setViewName("customError");

        model.addObject("error", ex.getErrString());

        System.out.println("Exception handled " + ex.getErrString());

        // Render the appropriate custom view based on the error condition
        // For example, you can check the error message or any other condition to determine which view to render
        /*if ("Exception raised in postHandle".equals(ex.getErrString())) {
            model.setViewName("errorView1"); // Specify the view name for the first error condition
        } else {
            model.setViewName("errorView2"); // Specify the view name for the second error condition
        }*/

        return model;

    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "view not found")
    @ExceptionHandler(value = ViewException.class)
    public ModelAndView viewExceptionHandler(HttpServletRequest request, ViewException exception) {

        ModelAndView modelAndView = exception.getModelAndView();
        modelAndView = (modelAndView != null) ? modelAndView : new ModelAndView();

        ViewResolverImpl.setModelAndView(modelAndView);

        if ( modelAndView != null ) {

            System.out.println("Exception handled : " + exception.getErrString());

            modelAndView.addObject("error", exception.getErrString());

            modelAndView.addObject("url", request.getRequestURI());

            modelAndView.setViewName("error");

            return modelAndView;

        } else {

            ModelAndView modelAndView1 = new ModelAndView();

            modelAndView1.addObject("url", request.getRequestURI());

            System.out.println("Exception handled in else part of viewexception: " + exception.getErrString());

            return modelAndView1;
        }
    }
}
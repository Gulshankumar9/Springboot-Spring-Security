package com.custom.viewresolver.customexception;

import org.springframework.web.servlet.ModelAndView;

public class CustomException extends RuntimeException {

    private ModelAndView modelAndView;

    private String errString;

    private Exception exception;

    public CustomException(String errString, ModelAndView modelAndView) {

        this.modelAndView = modelAndView;
        this.errString    = errString;

    }

    public CustomException(String message) {

        super(message);

    }

    public CustomException(String message, Throwable cause, ModelAndView modelAndView, String errString,
                           Exception exception) {

        super(message, cause);
        this.modelAndView = modelAndView;
        this.errString    = errString;
        this.exception    = exception;
    }

    public CustomException(Throwable cause, ModelAndView modelAndView, String errString, Exception exception) {

        super(cause);
        this.modelAndView = modelAndView;
        this.errString    = errString;
        this.exception    = exception;
    }

    public ModelAndView getModelAndView() {

        return modelAndView;
    }

    public void setModelAndView(ModelAndView modelAndView) {

        this.modelAndView = modelAndView;
    }

    public String getErrString() {

        return errString;
    }

    public void setErrString(String errString) {

        this.errString = errString;
    }

    public Exception getException() {

        return exception;
    }

    public void setException(Exception exception) {

        this.exception = exception;
    }
}
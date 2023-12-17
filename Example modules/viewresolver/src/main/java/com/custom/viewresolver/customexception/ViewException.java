package com.custom.viewresolver.customexception;

import org.springframework.web.servlet.ModelAndView;

public class ViewException extends RuntimeException {

    private ModelAndView modelAndView;

    private String errString;

    private Exception ex;

    public ViewException(String exceptionRaisedInPostHandle, ModelAndView modelAndView) {

    }

    public ViewException() {

    }

    public ViewException(String message) {

        super(message);
    }

    public ViewException(String message, Throwable cause) {

        super(message, cause);
    }

    public ViewException(Throwable cause) {

        super(cause);
    }

    public ViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

        super(message, cause, enableSuppression, writableStackTrace);
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

    public Exception getEx() {

        return ex;
    }

    public void setEx(Exception ex) {

        this.ex = ex;
    }
}
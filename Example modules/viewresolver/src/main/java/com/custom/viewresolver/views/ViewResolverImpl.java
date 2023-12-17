package com.custom.viewresolver.views;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.Locale;
import java.util.Map;

public class ViewResolverImpl extends UrlBasedViewResolver {

    private static final ThreadLocal<ModelAndView> modelAndViewThreadLocal = new ThreadLocal<>();

    private final Map<String, String> VIEW_NAME_INDEX = Map.of("jsp", "/WEB-INF/views/error.jsp", "ftl", "welcome.ftl");

    public static ModelAndView getModelAndView() {

        return modelAndViewThreadLocal.get();
    }

    public static void setModelAndView(ModelAndView modelAndView) {

        modelAndViewThreadLocal.set(modelAndView);
    }

    public static void clearModelAndView() {

        modelAndViewThreadLocal.remove();
    }

    @Override
    protected View createView(String viewName, Locale locale) throws Exception {

        if ( viewName.equals("forward") || viewName.equals("redirect") ) {

            viewName = viewName + ":" + viewName + "To";
        }

        return super.createView(viewName, locale);
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        View view = null;

        if ( viewName.equals("forward") ) {

            ForwardViewImpl internalResourceViewImpl = new ForwardViewImpl();

            internalResourceViewImpl.setUrl(viewName + "To");

            view = internalResourceViewImpl;

        } else if ( viewName.equals("redirect") ) {

            RedirectViewImpl redirectViewImpl = new RedirectViewImpl();

            redirectViewImpl.setUrl(viewName + "To");

            redirectViewImpl.setPropagateQueryParams(true);

            view = redirectViewImpl;

        } else if ( viewName.equals("ftl") ) {

            /*FreeMarkerViewImpl freeMarkerViewImpl = new FreeMarkerViewImpl();

            freeMarkerViewImpl.setUrl(VIEW_NAME_INDEX.get("ftl"));

            freeMarkerViewImpl.setExposeRequestAttributes(true);

            view = freeMarkerViewImpl;*/

            //viewName = VIEW_NAME_INDEX.get("ftl");

        } else if ( viewName.equals("jsp") || viewName.equals("error") ) {

            ModelAndView modelAndView = getModelAndView();

            if ( modelAndView != null ) {

                modelAndView.addObject("error", "model access from viewresolverimpl");

            }
            view = new JstlView(VIEW_NAME_INDEX.get("jsp"));
        } else {
            view = super.resolveViewName(viewName, locale);
        }

        return view;
    }

    @Override
    protected AbstractUrlBasedView instantiateView() {

        super.setViewClass(ForwardViewImpl.class);

        return super.instantiateView();
    }
}
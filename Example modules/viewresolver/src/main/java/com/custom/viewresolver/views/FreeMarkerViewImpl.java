package com.custom.viewresolver.views;

import com.custom.viewresolver.customexception.CustomJavaClass;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

public class FreeMarkerViewImpl extends FreeMarkerView {

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        //custom code
        model.put("message", "");
        super.exposeHelpers(model, request);
        //throw new CustomException("Custom exception message");
    }

    @Override
    protected SimpleHash buildTemplateModel(Map<String, Object> model, HttpServletRequest request,
                                            HttpServletResponse response) {

        SimpleHash simpleHash = super.buildTemplateModel(model, request, response);
        simpleHash.put("CustomJavaClass", new CustomJavaClass());
        simpleHash.put("model", model);
        return simpleHash;
    }

    @Override
    protected void processTemplate(Template template, SimpleHash model, HttpServletResponse response) throws IOException, TemplateException {

        Writer stringwriter = new StringWriter();

        template.process(model, stringwriter);

        String writerstring = stringwriter.toString();

        Writer responsewrWriter = response.getWriter();

        responsewrWriter.write(writerstring);

        //super.processTemplate(template, model, response);
    }

    @Override
    protected Template getTemplate(String name, Locale locale) throws IOException {

        String url = "welcome.ftl";

        return super.getTemplate(url, locale);
    }

}
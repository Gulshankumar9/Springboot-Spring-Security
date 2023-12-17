package com.custom.viewresolver.views;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Map;

public class ForwardViewImpl extends InternalResourceView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        model.put("queryParam1", "queryParam1val");

        model.put("queryParam2", "queryParam2val");

        super.renderMergedOutputModel(model, request, response);

    }
}
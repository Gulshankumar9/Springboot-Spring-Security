package com.custom.viewresolver.views;

import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

public class RedirectViewImpl extends RedirectView {

    @Override
    protected Map<String, Object> queryProperties(Map<String, Object> model) {

        Map<String, Object> returnMap = new HashMap<>();

        returnMap.put("qParam1", "qParamval1");
        returnMap.put("qParam2", "qParamval2");

        return returnMap;
    }
}
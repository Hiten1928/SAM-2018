package com.sparkSAM2018.ui;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetHomeRoute implements TemplateViewRoute {

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "HEYEYYEYEY");


        return new ModelAndView(vm, "home.ftl");
    }
}

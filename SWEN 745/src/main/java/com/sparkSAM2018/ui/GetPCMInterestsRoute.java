package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPCMInterestsRoute implements TemplateViewRoute{

    private final SAMCenter samCenter;

    public GetPCMInterestsRoute(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);
        vm.put("pcmInterests", samCenter.getEnglishInterests());

        return new ModelAndView(vm,"pcmInterests.ftl");
    }
}

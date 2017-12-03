package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.Map;

public class GetPCCRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetPCCRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        if(!samCenter.getPccNote().isEmpty()){
            vm.put("notification", samCenter.getPccNote().get(0).getMessage());
        }
        return new ModelAndView(vm, "pcc.ftl");
    }
}

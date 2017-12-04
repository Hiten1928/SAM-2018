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

        if(request.queryParams("notification") != null){
            String notie = request.queryParams("notification");
            for(int x = 0; x < samCenter.getPccNote().size(); x++){
                if(samCenter.getPccNote().get(x).getMessage().equals(notie)){
                    samCenter.getPccNote().remove(samCenter.getPccNote().get(x));
                }
            }
        }

        List<String> noties = new ArrayList<>();
        for(int x = 0; x < samCenter.getPccNote().size(); x++){
            noties.add(samCenter.getPccNote().get(x).getMessage());
        }

        vm.put("notification",noties);
        return new ModelAndView(vm, "pcc.ftl");
    }
}

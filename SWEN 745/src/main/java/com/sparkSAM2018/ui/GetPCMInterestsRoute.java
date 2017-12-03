package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPCMInterestsRoute implements TemplateViewRoute{

    private final SAMCenter samCenter;

    private List<String> key = new ArrayList<>();
    private List<String> value = new ArrayList<>();

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

        System.out.println(samCenter.getEnglishInterests());

        for (String name: samCenter.getEnglishInterests().keySet()){
            key.add(name);
            value = samCenter.getEnglishInterests().get(name);
            System.out.println(name + " : " + value);
        }

        vm.put("pcmName",key);
        vm.put("interestsList", value);

        return new ModelAndView(vm,"pcmInterests.ftl");
    }
}

package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.*;

import java.util.*;

public class PostAssignPapers implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public PostAssignPapers(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);
        QueryParamsMap map=request.queryMap("assignedAuthor");

        String selected_pcm[] = map.values();
        String assigned_PCMS="";
        for(Object obj:selected_pcm) {
            assigned_PCMS=assigned_PCMS+(String)obj+"_";
            // System.out.println("PCM assigned: " + assigned_PCMS);
        }
        response.cookie("assigned_PCMS",assigned_PCMS);

        System.out.println(request.queryParams("paper"));
        System.out.println(request.queryParams("assignedAuthor"));

        vm.put("samCenter",samCenter);
        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        return new ModelAndView(vm, "assignPapers.ftl");
    }
}

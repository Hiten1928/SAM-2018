package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Notification;
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
        QueryParamsMap map = request.queryMap("assignedAuthor");
        QueryParamsMap map2 = request.queryMap("paper");

        String selected_pcm[] = map.values();
        String paper[] = map2.values();

        String assigned_PCMS="";
        String assigned_paper="";
        for(Object obj:selected_pcm) {
            assigned_PCMS = assigned_PCMS+(String)obj+"_";
        }
        for(Object obj:paper) {
            assigned_paper = (String)obj;
        }
        response.cookie("assigned_PCMS",assigned_PCMS);
        response.cookie("assigned_paper",assigned_paper);

        samCenter.getPcmNote().add(new Notification("You have been assigned a paper for review"));

        vm.put("samCenter",samCenter);
        vm.put("papersSubmitted",samCenter.getPapersSubmitted());

        return new ModelAndView(vm, "assignPapers.ftl");
    }
}

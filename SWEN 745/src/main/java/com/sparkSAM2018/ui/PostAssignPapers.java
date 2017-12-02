package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.*;

import static spark.Spark.halt;

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

        System.out.println(request.queryParams("paper"));
        System.out.println(request.queryParams("assignedAuthor"));

        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        return new ModelAndView(vm, "assignPapers.ftl");
    }
}

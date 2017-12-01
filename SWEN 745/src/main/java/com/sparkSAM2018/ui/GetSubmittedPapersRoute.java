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

public class GetSubmittedPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetSubmittedPapersRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        List<String> papersSubmitted = new ArrayList<>();
        for(int x = 0; x < samCenter.getSubmittedPapers().size(); x++){
            papersSubmitted.add(samCenter.getSubmittedPapers().get(x).getTitle() + " by " +
            samCenter.getSubmittedPapers().get(x).getAuthor() + ", version: " + samCenter.getSubmittedPapers().get(x).getVersion());
        }

        vm.put("papersSubmitted",papersSubmitted);
        return new ModelAndView(vm, "submittedPapers.ftl");
    }
}

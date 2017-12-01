package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostReviewRequest implements TemplateViewRoute {

    private final SAMCenter samCenter;
    List<String> poop = new ArrayList<>();

    public PostReviewRequest(SAMCenter samCenter) {
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        String str = request.body();
        List<String> strings = Arrays.asList(str.replaceAll("^.*?=", "").split("by.*?(=|$)"));

        for(int x = 0; x < strings.size(); x++){
            String stris = strings.get(x);
            String stris2 = stris.replaceAll("\\+"," ");
            poop.add(stris2);
        }
        System.out.println(poop);

        return new ModelAndView(vm,"submittedPapers.ftl");
    }


}

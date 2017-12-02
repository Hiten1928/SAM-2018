package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import com.sparkSAM2018.model.Paper;
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
    List<String> poop2 = new ArrayList<>();

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
        for(int x = 0; x < strings.size(); x++){
            String st = poop.get(x);
            String stris3 = st.replaceAll("\\s$","");
            poop2.add(stris3);
        }

        List<Paper> submittedPapers = samCenter.getSubmittedPapers();
        for(int y = 0; y < poop2.size(); y++){
            for(int a = 0; a < submittedPapers.size(); a++) {
                try {
                    if (submittedPapers.get(a).getTitle().equals(poop2.get(y))) {
                        System.out.println("yes");
                        Part part = submittedPapers.get(a).getPaper();
                        System.out.println(PostPaperRoute.getSubmittedFileName(part));
                    } else {
                        //do nothing
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("out of bounds");
                }
            }
        }

        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        return new ModelAndView(vm,"submittedPapers.ftl");
    }
}

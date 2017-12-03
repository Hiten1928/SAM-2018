package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import javax.servlet.http.Part;

import java.util.*;

public class PostReviewRequest implements TemplateViewRoute {

    private final SAMCenter samCenter;
    List<String> preFormattedTitle = new ArrayList<>();
    List<String> finalizedTitles = new ArrayList<>();

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
             preFormattedTitle.add(stris2);
        }

        for(int x = 0; x < strings.size(); x++){
            String st = preFormattedTitle.get(x);
            String stris3 = st.replaceAll("\\s$","");
            finalizedTitles.add(stris3);
        }

        for(int y = 0; y < finalizedTitles.size(); y++){
            for(int a = 0; a < samCenter.getSubmittedPapers().size(); a++) {
                try {
                    if (samCenter.getSubmittedPapers().get(a).getTitle().equals(finalizedTitles.get(y))) {
                        Part part = samCenter.getSubmittedPapers().get(a).getPaper();
                        samCenter.getInterests().add(part);
                    } else {
                        //do nothing
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("out of bounds");
                }
            }
        }
        samCenter.getEnglishInterests().put(request.cookie("usernamePCM"),finalizedTitles);

        preFormattedTitle = new ArrayList<>();
        finalizedTitles = new ArrayList<>();

        vm.put("papersSubmitted",samCenter.getPapersSubmitted());
        return new ModelAndView(vm,"submittedPapers.ftl");
    }
}

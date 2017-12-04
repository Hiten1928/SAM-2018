package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.lang.reflect.Array;
import java.util.*;

public class GetReviewPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;
    private List<String> key = new ArrayList<>();
    private List<String> value = new ArrayList<>();

    public GetReviewPapersRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response){
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        ArrayList assigned_PCMS_list = new ArrayList();

        try {
            String pcms_Assigned = request.cookie("assigned_PCMS");
            String paper_assigned = request.cookie("assigned_paper");

            StringTokenizer st1 = new StringTokenizer(pcms_Assigned, "_");
            StringTokenizer st2 = new StringTokenizer(paper_assigned, "_");
            while (st1.hasMoreTokens()) {
                assigned_PCMS_list.add(st1.nextElement());
                //System.out.println(st1.nextElement());
            }
            while (st2.hasMoreTokens()) {
                Object paper = st2.nextElement();
                paper_assigned = (String) paper;
            }
            for (Object obj : assigned_PCMS_list)
                System.out.println("in the list:" + (String) obj);

            vm.put("PCM_list", assigned_PCMS_list);
            vm.put("paperName", paper_assigned);
        }
        catch(NullPointerException e){
            return new ModelAndView (vm,"review.ftl");
        }

        //Map<String, ArrayList> list_map = new HashMap<>();
        //list_map.put(paper_assigned,assigned_PCMS_list);

        return new ModelAndView (vm,"review.ftl");
    }
}
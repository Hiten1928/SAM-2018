package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GetReviewPapersRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetReviewPapersRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) throws Exception {

        Map<String, Object> vm = new HashMap<>();
        ArrayList assigned_PCMS_list=new ArrayList();
        System.out.println("getreviewPapersRoute called..");
        String pcms_Assigned=request.cookie("assigned_PCMS");

        StringTokenizer st1 = new StringTokenizer(pcms_Assigned,"_");
        while(st1.hasMoreTokens()) {
            assigned_PCMS_list.add(st1.nextElement());
            //System.out.println(st1.nextElement());
        }
        //System.out.println("getReviewPapersRoute: "+pcms_Assigned);
        vm.put("title", GetHomeRoute.TITLE);

        for(Object obj:assigned_PCMS_list)
            System.out.println("in the list:"+(String)obj);
        vm.put("PCM_list",assigned_PCMS_list);

        return new ModelAndView (vm,"review.ftl");
    }
}

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

public class GetManageAccountsRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public GetManageAccountsRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        List<String> aNames = new ArrayList<>();
        for(int x=0; x<samCenter.getAuthorUsernameList().size(); x++){
            aNames.add(samCenter.getAuthorUsernameList().get(x).getAuthorUsername());
        }

        List<String> pcc = new ArrayList<>();
        for(int x=0; x<samCenter.getPCCUsernameList().size(); x++){
            pcc.add(samCenter.getPCCUsernameList().get(x).getPCCName());
        }

        List<String> pcms = new ArrayList<>();
        for(int x=0; x<samCenter.getPCMUsernameList().size(); x++){
            pcms.add(samCenter.getPCMUsernameList().get(x).getPCMName());
        }

        vm.put("authors", aNames);
        vm.put("pcms", pcms);
        vm.put("pcc", pcc);

        return new ModelAndView(vm, "manageAccounts.ftl");
    }
}

package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostNameRoute implements TemplateViewRoute {

    final SAMCenter samCenter = new SAMCenter();

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        final String radioValue = request.queryParams("memberType");
        final String username = request.queryParams("username");


        return validateSignin(vm, username, radioValue);
    }

    private ModelAndView validateSignin(Map<String, Object> vm, String username, String radioValue){

        switch(radioValue){
            case "author":
                final List author = samCenter.getAuthorUsernameList();
                if(author.contains(username)){
                    vm.put("title", GetHomeRoute.TITLE);
                    return new ModelAndView(vm, PostRegistrationRoute.AUTHOR_FTL);
                }
                else{
                    vm.put("author", author.size());
                    vm.put("usernameError", "Invalid username, please try again");
                    return new ModelAndView(vm, "signin.ftl");
                }
            case "pcm":
                final List pcm = samCenter.getPCMUsernameList();
                if(pcm.contains(username)){
                    vm.put("title", GetHomeRoute.TITLE);
                    return new ModelAndView(vm, PostRegistrationRoute.PCM_FTL);
                }
            case "pcc":
                final List pcc = samCenter.getPCCUsernameList();
                if(pcc.contains(username)){
                    vm.put("title", GetHomeRoute.TITLE);
                    return new ModelAndView(vm, PostRegistrationRoute.PCC_FTL);
                }
            case "administrator":
                final String admin = samCenter.getAdministratorName();
                if(admin.equals(username)){
                    vm.put("title", GetHomeRoute.TITLE);
                    return new ModelAndView(vm, PostRegistrationRoute.ADMIN_URL);
                }
            default:
                vm.put("usernameError", "Invalid username, please try again.");
                return new ModelAndView(vm, PostRegistrationRoute.SIGNIN_FTL);
        }
    }
}
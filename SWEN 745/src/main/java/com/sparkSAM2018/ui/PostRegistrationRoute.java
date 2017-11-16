package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRegistrationRoute implements TemplateViewRoute {

    static final String AUTHOR_FTL = "author.ftl";
    static final String PCM_FTL = "pcm.ftl";
    static final String PCC_FTL = "pcc.ftl";
    static final String ADMIN_URL = "admin.ftl";
    static final String SIGNIN_FTL = "signin.ftl";

    final SAMCenter samCenter;

    public PostRegistrationRoute(SAMCenter samCenter){
        this.samCenter = samCenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", GetHomeRoute.TITLE);

        final String radioValue = request.queryParams("memberType");
        final String username = request.queryParams("username");

        final boolean usernameAvailable = isNameAvailable(username, radioValue);
        if(usernameAvailable){
            return new ModelAndView(vm, SIGNIN_FTL);
        }
        else{
            vm.put("usernameError", "Username already taken, please choose another.");
            return new ModelAndView(vm, "registration.ftl");
        }
    }


    private boolean isNameAvailable(String username, String radioValue){

        switch(radioValue){
            case "author":
                final List authorNames = samCenter.getAuthorUsernameList();
                if(!authorNames.contains(username)){
                    authorNames.add(username);
                    return true;
                }
                else{
                    return false;
                }
            case "pcm":
                final List pcmNames = samCenter.getPCMUsernameList();
                if(!pcmNames.contains(username)){
                    pcmNames.add(username);
                    return true;
                }
                else{
                    return false;
                }
            case "pcc":
                final List pccNames = samCenter.getPCCUsernameList();
                if(!pccNames.contains(username)){
                    pccNames.add(username);
                    return true;
                }
                else{
                    return false;
                }
            default:
                return false;
        }
    }
}


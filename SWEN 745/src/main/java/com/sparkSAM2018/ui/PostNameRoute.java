package com.sparkSAM2018.ui;

import com.sparkSAM2018.application.SAMCenter;

import com.sparkSAM2018.model.Author;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.halt;

public class PostNameRoute implements TemplateViewRoute {

    private final SAMCenter samCenter;

    public PostNameRoute(SAMCenter samCenter){
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

        if(radioValue == null){
            return invalidUsernameError(vm);
        }
        else{
            return validateSignin(vm, username, radioValue, response);
        }
    }

    private ModelAndView validateSignin(Map<String, Object> vm, String username, String radioValue, Response response){
        switch(radioValue){
            case "author":
                if(samCenter.getSomething(username,"author")){
                    response.cookie("usernameAuthor",username);
                    response.redirect("/author");
                    halt();
                    return null;
                }
                else{
                    return invalidUsernameError(vm);
                }
            case "pcm":
                if(samCenter.getSomething(username,"pcm")){
                    response.cookie("usernamePCM",username);
                    response.redirect(String.format("/pcm"));
                    return null;
                }
                else{
                    return invalidUsernameError(vm);
                }
            case "pcc":
                if(samCenter.getSomething(username,"pcc")){
                    response.cookie("usernamePCC",username);
                    response.redirect("/pcc");
                    halt();
                    return null;
                }
                else{
                    return invalidUsernameError(vm);
                }
            case "administrator":
                final String admin = samCenter.getAdministratorName();
                if(admin.equals(username)){
                    response.redirect("/admin");
                    halt();
                    return null;
                }
            default:
                return invalidUsernameError(vm);
        }
    }

    private ModelAndView invalidUsernameError(Map<String, Object> vm){
        vm.put("usernameError", "Invalid username, please try again.");
        return new ModelAndView(vm, "signin.ftl");
    }
}
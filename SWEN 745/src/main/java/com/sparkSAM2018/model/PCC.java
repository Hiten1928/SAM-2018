package com.sparkSAM2018.model;

public class PCC {

    private String username;

    public PCC(String username){
        this.username = username;
    }

    public String getPCCName(){
        return username;
    }

    public boolean hasPCC(String name){
        return username.equals(name);
    }
}

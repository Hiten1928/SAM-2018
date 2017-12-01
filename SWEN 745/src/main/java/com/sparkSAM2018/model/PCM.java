package com.sparkSAM2018.model;

public class PCM {

    private String name;

    public PCM(String name){
        this.name = name;
    }

    public String getAuthorName(){
        return name;
    }

    public boolean hasPCM(String name){
        return name.equals(name);
    }
}

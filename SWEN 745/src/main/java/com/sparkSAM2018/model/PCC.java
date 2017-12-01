package com.sparkSAM2018.model;

public class PCC {

    private String name;

    public PCC(String name){
        this.name = name;
    }

    public String getPCCName(){
        return name;
    }

    public boolean hasPCC(String name){
        return name.equals(name);
    }
}

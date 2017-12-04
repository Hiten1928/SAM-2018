package com.sparkSAM2018.model;

public class Author {

    private String name;

    public Author(String name){
        this.name = name;
    }

    public String getAuthorUsername(){
        return name;
    }

    public boolean hasAuthor(String othername){
        return name.equals(othername);
    }
}

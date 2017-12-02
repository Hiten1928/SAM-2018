package com.sparkSAM2018.model;

import javax.servlet.http.Part;

public class Paper {

    private Author author;
    private String title;
    private int version;
    private Part paper;

    public Paper(Author author, String title, int version, Part paper){
        this.author = author;
        this.title = title;
        this.version = version;
        this.paper = paper;
    }

    public String getAuthor(){
        return author.getAuthorName();
    }

    public String getTitle(){
        return title;
    }

    public int getVersion(){
        return version;
    }

    public Part getPaper(){
        return paper;
    }
}

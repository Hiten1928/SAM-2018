package com.sparkSAM2018.model;

public class Paper {

    private Author author;
    private String title;
    private int version;

    public Paper(Author author, String title, int version){
        this.author = author;
        this.title = title;
        this.version = version;
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
}

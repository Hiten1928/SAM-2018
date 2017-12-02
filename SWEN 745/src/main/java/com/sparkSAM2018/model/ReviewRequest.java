package com.sparkSAM2018.model;

import javax.servlet.http.Part;
import java.util.List;
import java.util.Map;

public class ReviewRequest {

    private String pcmName;
    private List<Part> interests;

    public ReviewRequest(String pcmName, List<Part> interests){
        this.pcmName = pcmName;
        this.interests = interests;
    }

    public String getPcmName(){
        return pcmName;
    }

    public List<Part> getInterests(){
        return interests;
    }
}

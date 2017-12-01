package com.sparkSAM2018.model;

public class ReviewRequest {

    /*
        each request will be associated with a PCM

        request will be of List<Part>

        new ReviewRequest is created by:
            PCM selects radio buttons
            get everything before " by"
            find that title in papers list, get the Part associated with title

            List<Part> interests = new ArrayList<>();
            this = getStringBefore(" by")
            for list of papers{
                if index.getTitle().equals(this){
                    Part part = index.getPart()
                    interests.add(part)
                }
            }
            Review Request = new ReviewRequest(pcmSignedIn, interests)
     */
}

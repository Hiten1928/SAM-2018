package com.sparkSAM2018.application;

import com.sparkSAM2018.model.*;
import spark.Request;
import spark.Session;

import javax.servlet.http.Part;
import java.util.*;

/**
 *
 * The object to coordinate the state of the application.
 *
 */
public class SAMCenter {

    //
    // attributes
    //

    private List<Author> authorUsernames = new ArrayList<>();
    private List<PCM> pcmUsernames = new ArrayList<>();
    private List<PCC> pccUsernames = new ArrayList<>();

    private List<Paper> submittedPapers = new ArrayList<>();
    private List<String> papersSubmitted = new ArrayList<>();

    private List<Part> interests = new ArrayList<>();
    private Map<String, List<String>> englishInterests = new HashMap<>();

    private List<Notification> pccNote = new ArrayList<>();

    private String administratorName = "Administrator";

    //
    // constructor
    //

    public SAMCenter() {

    }

    /**
     * Ends the user's session, freeing up their name and logging them out
     *
     * @param session
     * @param request
     *
     */
    public void end(Session session, Request request) {
        // validation
        Objects.requireNonNull(session, "session must not be null");
        // remove the game from the user's session
        session.removeAttribute("checkGame");
        // do some application-wide book-keeping
        synchronized (this) {  // protect the critical code

        }
    }

    public List<Author> getAuthorUsernameList() {
        return authorUsernames;
    }

    public List<PCM> getPCMUsernameList() {
        return pcmUsernames;
    }

    public List<PCC> getPCCUsernameList() {
        return pccUsernames;
    }

    public String getAdministratorName(){
        return administratorName;
    }

    public List<Paper> getSubmittedPapers(){
        return submittedPapers;
    }

    public List<String> getPapersSubmitted(){
        return papersSubmitted;
    }

    public List<Part> getInterests(){
        return interests;
    }

    public List<Notification> getPccNote(){
        return pccNote;
    }

    public void clearNotifications(){
        pccNote.clear();
    }

    public Map<String, List<String>> getEnglishInterests(){
        return englishInterests;
    }

    public boolean getSomething(String name, String type){
        switch(type){
            case "author":
                for (Author author: authorUsernames) {
                    if(author.hasAuthor(name)){
                        return true;
                    }
                }
                break;
            case "pcm":
                for (PCM pcm: pcmUsernames) {
                    if(pcm.hasPCM(name)){
                        return true;
                    }
                }
                break;
            case "pcc":
                for (PCC pcc: pccUsernames) {
                    if(pcc.hasPCC(name)){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}


package com.sparkSAM2018.application;

//import com.sparkSAM2018.model.SAMGame;
import spark.Request;
import spark.Session;
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

    private List<String> authorUsernames = new ArrayList<>();
    private List<String> pcmUsernames = new ArrayList<>();
    private List<String> pccUsernames = new ArrayList<>();

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

    public List getAuthorUsernameList() {
        return authorUsernames;
    }

    public List getPCMUsernameList() {
        return pcmUsernames;
    }

    public List getPCCUsernameList() {
        return pccUsernames;
    }

    public String getAdministratorName(){
        return administratorName;
    }
}


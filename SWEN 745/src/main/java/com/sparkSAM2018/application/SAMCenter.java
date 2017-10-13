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


    //
    // constructor
    //

    public SAMCenter() {

    }


    /**
     * Get the {@linkplain //CheckersGame game} for the current user
     *
     * @param session
     *   The HTTP session
     *
     * @return
     *   A existing or new {@link //CheckersGame}
     */
    /*public CheckersGame get(final Session session) {
        // validation
        Objects.requireNonNull(session, "session must not be null");
        CheckersGame game = session.attribute("checkGame");
        if (game == null) {
            // create new game
            game = new CheckersGame();
            session.attribute("checkGame", game);
        }
        return game;
    }*/

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

}


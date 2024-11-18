package it.unibo.mvc;

import java.util.List;

/**
 * A simple controller interface.
 */
public interface Controller {

    /**
     * 
     * @return the current string
     */
    String getCurrentString();

    /**
     * 
     * @param newString
     */
    void setCurrentString(String newString);

    /**
     * 
     * @return a copy of the history
     */
    List<String> getHistory();

    /**
     * 
     */
    void printCurrentString();

}

package it.unibo.mvc;
import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of the interface controlle.
 */
public final class SimpleController implements Controller {

    private String currentString = "";
    private final List<String> history = new LinkedList<>();

    /**
     * @return the current string
     */
    @Override
    public String getCurrentString() {
        return currentString;
    }

    /**
     * @param newString
     */
    @Override
    public void setCurrentString(final String newString) {
        if (newString == null) {
            throw new IllegalArgumentException("The new string cannot be null");
        }
        currentString = newString;
    }

    /**
     * @return a copy of the history
     */
    @Override
    public List<String> getHistory() {
        return new LinkedList<>(this.history);
    }

    /**
     * 
     */
    @Override
    public void printCurrentString() {
        if (currentString.isEmpty()) {
            throw new IllegalStateException("Cuurent string is empty");
        }
        history.add(currentString);
        System.out.println(currentString); //NOPMD required
    }
}

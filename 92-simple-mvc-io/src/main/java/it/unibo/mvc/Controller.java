package it.unibo.mvc;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
final class Controller {
    private File file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt");

    /**
     * Write in the file the message in input.
     * @param input
     */
    public void write(final String input) {
        try (PrintStream ps = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
            ps.print(input);
        } catch (final IOException ex) {
            System.out.println("Error with the file:" + ex.getMessage()); // NOPMD required
        }
    }

    /**
     * 
     * @param file
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * 
     * @return the current file of the controller
     */
    public File getFile() {
        return this.file;
    }

    /**
     * 
     * @return the path of the current file of controller
     */
    public String getPath() {
        return this.file.getPath();
    }
}

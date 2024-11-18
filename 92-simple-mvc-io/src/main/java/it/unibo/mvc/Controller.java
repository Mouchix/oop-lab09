package it.unibo.mvc;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
final public class Controller {
    private File file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt");

    public void write(String input) {
        try (final PrintStream ps = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
            ps.print(input);
        } catch (final IOException ex) {
            System.out.println("Error with the file:" + ex.getMessage());
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public String getPath() {
        return this.file.getPath();
    }
}

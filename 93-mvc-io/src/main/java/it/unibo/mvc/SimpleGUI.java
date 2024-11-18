package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "A simple GUI";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new SimpleController();

    /**
     * Create a new SimpleGUI.
     */
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        mainPanel.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        mainPanel.add(textArea, BorderLayout.CENTER);
        final JPanel secondPanel = new JPanel();
        final JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setCurrentString(textField.getText());
                textField.setText("");
                controller.printCurrentString();
            }
        });
        secondPanel.add(printButton);
        final JButton showHistoryButton = new JButton("Show history");
        showHistoryButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final StringBuilder history = new StringBuilder();
                for (final String s: controller.getHistory()) {
                    history.append(s).append('\n');
                }
                textArea.setText(history.toString());
            }
        });
        secondPanel.add(showHistoryButton);
        mainPanel.add(secondPanel, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     * @param args ignores
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}

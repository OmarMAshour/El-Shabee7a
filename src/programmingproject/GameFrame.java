/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingproject;

import java.awt.DisplayMode;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static programmingproject.ProgrammingProject.WINDOW_HEIGHT;
import static programmingproject.ProgrammingProject.WINDOW_WIDTH;

/**
 *
 * @author n0krashy
 */
public class GameFrame extends JFrame {

    DisplayMode dm;
    Screen s;
    public static IntroPanel ip;

    public GameFrame() throws InterruptedException, IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dm = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        s = new Screen();

        ip = new IntroPanel();
        add(ip);
        
        s.setFullScreen(dm, this);
    }

    public void showPanel(JPanel p) {
        add(p);
        p.setVisible(true);
        validate();
        repaint();
        // is a must to get the focus of keyboard to the new panel and keys work
        p.requestFocusInWindow();
    }

}

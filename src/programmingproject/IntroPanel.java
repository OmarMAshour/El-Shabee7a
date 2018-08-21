/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingproject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static programmingproject.GameFrame.ip;
import static programmingproject.ProgrammingProject.gameFrame;

/**
 *
 * @author n0krashy
 */
public class IntroPanel extends JPanel {

    public static MainMenuPanel mp;
    public IntroPanel() throws InterruptedException, IOException {
        add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/Logo.gif"))));
        
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                try {
                    mp = new MainMenuPanel();
                } catch (IOException ex) {
                    Logger.getLogger(IntroPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                gameFrame.remove(ip);
                gameFrame.showPanel(mp);                
            }
        },
                4000
        );
    }
}

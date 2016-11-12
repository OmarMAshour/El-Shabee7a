package programmingproject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static programmingproject.ProgrammingProject.*;

public class HighScoreWindow extends JFrame {

    private JLabel HighScores;
    private ImageIcon BKlogo;
    private ImageIcon BKlogo2;
    private JLabel BKimgLabel;

    public HighScoreWindow() {

        DisplayMode dm = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon("HighScoresBackground2.jpg")));

        BKlogo = new ImageIcon("Back1.png");
        BKlogo2 = new ImageIcon("Back.png");
        BKimgLabel = new JLabel();
        BKimgLabel.setIcon(BKlogo);
//        JPanel logoPnl = new JPanel();
//        logoPnl.setLayout(new FlowLayout());
//        logoPnl.setBackground(Color.WHITE);
//        logoPnl.add(imgLabel);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        String Summition = "<html>";

        int j = 1;
        for (int i = HIGHSCORES.length - 1; i >= 0; i--) {
            if (HIGHSCORES[i] != 0) {
                Summition += j + ". \t \t \t" + HIGHSCORES[i] + "<br><br>";
                j++;

            }
            if (j == 10) {
                break;
            }
        }

        Summition += "</html>";

        Summition = Summition.replaceAll("\t", "    ");
        HighScores = new JLabel(Summition, JLabel.CENTER);
        HighScores.setForeground(Color.BLUE);
        HighScores.setFont(new Font("Serif", Font.BOLD, 32));
        BKimgLabel.setBorder(new EmptyBorder(20, 20, 20, 20));

//        c.add(logoPnl,BorderLayout.NORTH);
        c.add(HighScores, BorderLayout.CENTER);
        //  c.add(c);
        c.add(BKimgLabel, BorderLayout.SOUTH);

        Screen s = new Screen();

        try {
            s.setFullScreen(dm, this);

        } catch (Exception e) {

            System.out.println("Exception in setting MainWindow to full screen mode");
            this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        }

        BKimgLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {

                BKimgLabel.setIcon(BKlogo2);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                dispose();
                try {
                    MainWindow mw = new MainWindow();
                } catch (IOException ex) {
                    Logger.getLogger(HighScoreWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {

                BKimgLabel.setIcon(BKlogo);

            }

        });
        this.setVisible(true);
    }

}

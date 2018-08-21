package programmingproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static programmingproject.ProgrammingProject.*;

public class HighScorePanel extends JPanel {

    private JLabel HighScores;
    private ImageIcon BKlogo;
    private ImageIcon BKlogo2;
    private JLabel BKimgLabel;
    private final JLabel backgroundLbl;

    public HighScorePanel() {
        backgroundLbl = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/HighScoresBackground2.jpg")));

        BKlogo = new ImageIcon(getClass().getClassLoader().getResource("resources/Back1.png"));
        BKlogo2 = new ImageIcon(getClass().getClassLoader().getResource("resources/Back.png"));
        BKimgLabel = new JLabel();
        BKimgLabel.setIcon(BKlogo);
        setLayout(null);

        backgroundLbl.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        BKimgLabel.setBounds(20, (WINDOW_HEIGHT) - 139, 272, 119);

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
        HighScores.setForeground(Color.RED);
        HighScores.setBounds(WINDOW_WIDTH / 4, WINDOW_HEIGHT / 4, WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
        HighScores.setFont(new Font("Serif", Font.BOLD, 32));

        add(HighScores);
        add(BKimgLabel);
        add(backgroundLbl);

        BKimgLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {

                BKimgLabel.setIcon(BKlogo2);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                gameFrame.remove(HighScorePanel.this);
                gameFrame.showPanel(IntroPanel.mp);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BKimgLabel.setIcon(BKlogo);
            }

        });
    }

}

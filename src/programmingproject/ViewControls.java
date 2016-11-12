package programmingproject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static programmingproject.ProgrammingProject.WINDOW_HEIGHT;
import static programmingproject.ProgrammingProject.WINDOW_WIDTH;

public class ViewControls extends JFrame {

    private ImageIcon BKlogo;
    private ImageIcon BKlogo2;
    private JLabel BKimgLabel;

    public ViewControls() throws IOException {
        DisplayMode dm = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon("ViewControls.jpg")));

        this.getContentPane().setBackground(Color.BLACK);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        BKlogo = new ImageIcon("Back1.png");
        BKlogo2 = new ImageIcon("Back.png");
        BKimgLabel = new JLabel();
        BKimgLabel.setIcon(BKlogo);
        BKimgLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        c.add(BKimgLabel, BorderLayout.SOUTH);

        Screen s = new Screen();

        try {
            s.setFullScreen(dm, this);
        } catch (Exception e) {

            System.out.println("Exception in setting StartingWindow to full screen mode");
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

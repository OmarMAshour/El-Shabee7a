package programmingproject;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import static programmingproject.ProgrammingProject.WINDOW_HEIGHT;
import static programmingproject.ProgrammingProject.WINDOW_WIDTH;
import static programmingproject.ProgrammingProject.gameFrame;

public class ViewControls extends JPanel {

    private ImageIcon BKlogo;
    private ImageIcon BKlogo2;
    private JLabel BKimgLabel;
    private final JLabel backgroundLbl;

    public ViewControls() throws IOException {
        backgroundLbl = new JLabel(new ImageIcon("ViewControls.jpg"));
        setLayout(null);
        BKlogo = new ImageIcon("Back1.png");
        BKlogo2 = new ImageIcon("Back.png");
        BKimgLabel = new JLabel();
        BKimgLabel.setIcon(BKlogo);
        
        backgroundLbl.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        BKimgLabel.setBounds(20, (WINDOW_HEIGHT) - 139, 272, 119);

        
        add(BKimgLabel);
        add(backgroundLbl);
        

        BKimgLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                BKimgLabel.setIcon(BKlogo2);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                gameFrame.remove(ViewControls.this);
                gameFrame.showPanel(IntroPanel.mp);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BKimgLabel.setIcon(BKlogo);
            }

        });
    }

}

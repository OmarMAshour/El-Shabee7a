/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingproject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static programmingproject.ProgrammingProject.*;
import static programmingproject.ProgrammingProject.WINDOW_WIDTH;

// delete selectMap_Multi, add boolean given from previous panel, if multi == true open multiPanel
public class SelectMap extends JPanel {

    private JLabel backgroundLbl;
    private JLabel ASUlabel;
    private ImageIcon ASUicon1;
    private ImageIcon ASUicon2;
    private JLabel BKimgLabel;
    private ImageIcon BKlogo;
    private ImageIcon BKlogo2;
    private JLabel PyramidsLabel;
    private ImageIcon PyramidsIcon1;
    private ImageIcon PyramidsIcon2;

    public SelectMap() {
        backgroundLbl = new JLabel(new ImageIcon("SelectMap.jpg"));
        BKlogo = new ImageIcon("Back1.png");
        BKlogo2 = new ImageIcon("Back.png");
        BKimgLabel = new JLabel();
        BKimgLabel.setIcon(BKlogo);
        ASUicon1 = new ImageIcon("ASUlogo1.png");
        ASUicon2 = new ImageIcon("ASUlogo2.png");
        ASUlabel = new JLabel();
        ASUlabel.setIcon(ASUicon1);
        PyramidsIcon1 = new ImageIcon("PyramidsLogo1.png");
        PyramidsIcon2 = new ImageIcon("PyramidsLogo2.png");
        PyramidsLabel = new JLabel();
        PyramidsLabel.setIcon(PyramidsIcon1);

        setLayout(null);

        backgroundLbl.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        BKimgLabel.setBounds(20, (WINDOW_HEIGHT) - 139, 272, 119);
        PyramidsLabel.setBounds((WINDOW_WIDTH / 2) - (76 + 672), (WINDOW_HEIGHT / 2) - 120, 672, 353);
        ASUlabel.setBounds((WINDOW_WIDTH / 2) + 76, (WINDOW_HEIGHT / 2) - 120, 672, 353);

        add(PyramidsLabel);
        add(ASUlabel);
        add(BKimgLabel);
        add(backgroundLbl);

        BKimgLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                BKimgLabel.setIcon(BKlogo2);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                gameFrame.remove(SelectMap.this);
                gameFrame.showPanel(IntroPanel.mp);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BKimgLabel.setIcon(BKlogo);
            }

        });

        PyramidsLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                PyramidsLabel.setIcon(PyramidsIcon2);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                gameFrame.remove(SelectMap.this);
                try {
                    SinglePanel sp = new SinglePanel();
                    gameFrame.showPanel(sp);
                } catch (IOException ex) {
                    Logger.getLogger(HighScorePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {
                PyramidsLabel.setIcon(PyramidsIcon1);
            }

        });

        ASUlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {

                ASUlabel.setIcon(ASUicon2);
            }

            @Override
            public void mouseClicked(MouseEvent me) {
                gameFrame.remove(SelectMap.this);
                try {
                    ASU_BACKGROUND = true;
                    SinglePanel sp = new SinglePanel();
                    gameFrame.showPanel(sp);
                } catch (IOException ex) {
                    Logger.getLogger(HighScorePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseExited(MouseEvent me) {

                ASUlabel.setIcon(ASUicon1);

            }

        });
    }

}

package programmingproject;

import java.util.Arrays;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static programmingproject.ProgrammingProject.*;
import java.util.TimerTask;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SinglePanel extends JPanel {

    private Hulk hulk;
    private BlackWidow blackwidow;
    private JLabel bkHolder;
    private ImageIcon background;
    private javax.swing.Timer timer;
    private java.util.Timer timer_util;
    private HulkHealth hulkhealth;
    private BlackWidowHealth blackwidowhealth;
    private javax.swing.Timer timer2;
    private javax.swing.Timer timer4;
    private javax.swing.Timer timer5;
    private int i7 = 0, i14 = 0;
    private javax.swing.Timer timer3;
    private Timers timersphoto;
   
    private javax.swing.Timer movingBW;
    private ImageIcon blackwidowWinsIcon;
    private ImageIcon hulkWinsIcon;
    private ImageIcon drawIcon;
    private ImageIcon scoreIcon;
    private ImageIcon backIcon;
    private boolean hulkAngrySoundPlayed;

    private JLabel WinnerLbl;
    private JLabel ScoreIconLbl;
    private JLabel ScoreAmountLbl;
    private JLabel BackLbl;

    private Random rand = new Random();

    public SinglePanel() throws IOException {

        WinnerLbl = new JLabel();

        ScoreIconLbl = new JLabel();
        ScoreAmountLbl = new JLabel();

        BackLbl = new JLabel();

        blackwidowWinsIcon = new ImageIcon("BWwins.png");
        hulkWinsIcon = new ImageIcon("HulkWins.png");
        drawIcon = new ImageIcon("Draw.png");
        scoreIcon = new ImageIcon("Score.png");
        backIcon = new ImageIcon("Back1.png");
        
        hulkAngrySoundPlayed = false;
        timer_util = new java.util.Timer();

        timersphoto = new Timers();
        hulk = new Hulk(WINDOW_WIDTH / 32, (4 * WINDOW_HEIGHT) / 9);
        blackwidow = new BlackWidow(WINDOW_WIDTH - ((WINDOW_WIDTH / 32) + HERO_WIDTH), (4 * WINDOW_HEIGHT) / 9);

        hulkhealth = new HulkHealth();
        blackwidowhealth = new BlackWidowHealth();

        setFocusable(true);
        addKeyListener(new TAdapter());

        bkHolder = new JLabel();
        if (ASU_BACKGROUND == true) {

            background = new ImageIcon("ASU.jpg");
            try {
                InputStream in = new FileInputStream("Voice_023.wav");

                AudioStream audioStream = new AudioStream(in);

                AudioPlayer.player.start(audioStream);

            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
            }
        } else {
            background = new ImageIcon("pyramid-wallpaper-1.jpg");
            try {
                InputStream in = new FileInputStream("Voice_022.wav");

                AudioStream audioStream = new AudioStream(in);

                AudioPlayer.player.start(audioStream);

            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
            }
        }
        bkHolder.setIcon(background);
        bkHolder.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        WinnerLbl.setBounds((WINDOW_WIDTH / 2) - 465, (211 * WINDOW_HEIGHT) / 1080, 929, 310);

        ScoreIconLbl.setBounds((WINDOW_WIDTH / 2) - 100, ((211 * WINDOW_HEIGHT) / 1080) + 312, 109, 31);

        ScoreAmountLbl.setBounds((WINDOW_WIDTH / 2) + (-100 + 109 + 10), ((211 * WINDOW_HEIGHT) / 1080) + 280, 200, 100);
        ScoreAmountLbl.setForeground(Color.RED);
        ScoreAmountLbl.setFont(new Font("Serif", Font.BOLD, 32));

        BackLbl.setBounds((50 * WINDOW_WIDTH) / 1920, (928 * WINDOW_HEIGHT) / 1080, 272, 119);

        setLayout(null);

        add(WinnerLbl);

        add(ScoreAmountLbl);
        add(ScoreIconLbl);
        add(BackLbl);

        add(bkHolder);

        movingBW = new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int x;
                if (TIME_ENDS) {
                    x = 100;
                } else {
                    x = 0;
                    if (hulk.getX() > blackwidow.getX() && !inRange()) {
                        x = 2;
                    } else if (hulk.getX() < blackwidow.getX() && !inRange()) {
                        x = 1;
                    } else {
                        x = rand.nextInt(5) + 2;

                    }
                }
                switch (x) {
                    case 0: {
                        blackwidow.hit2();

                        break;

                    }
                    case 1: {
                        W = false;
                        A = true;
                        D = false;
                        ONE = false;
                        TWO = false;
                        break;
                    }
                    case 2: {
                        W = false;
                        A = false;
                        D = true;
                        ONE = false;
                        TWO = false;
                        break;
                    }
                    case 3: {
                        try {
                            blackwidow.hit1();
                        } catch (IOException ex) {
                            Logger.getLogger(SinglePanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                    case 4: {
                        blackwidow.hit2();

                        break;
                    }
                    case 5: {
                        try {
                            blackwidow.hit1();
                        } catch (IOException ex) {
                            Logger.getLogger(SinglePanel.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        break;
                    }
                    case 6: {
                        blackwidow.hit2();

                        break;
                    }
                }
            }
        });
        movingBW.start();
        timer3 = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (BLACKWIDOWBAR_NO == 20) {
                    SCORE = (60 - TIME_COUNTER) * (20 - HULKBAR_NO) * 100;

                    WinnerLbl.setIcon(hulkWinsIcon);
                    TIME_ENDS = true;

                    ScoreAmountLbl.setText("" + SCORE);
                    ScoreIconLbl.setIcon(scoreIcon);
                    BackLbl.setIcon(backIcon);

                } else {
                    checkHulkHit();
                    if (HULK_HIT) {
                        BLACKWIDOWBAR_NO++;
                    }

                }
            }
        });
        timer3.start();

        timer2 = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (HULKBAR_NO == 20) {
                    SCORE = (60 - TIME_COUNTER) * (20 - BLACKWIDOWBAR_NO) * 100;

                    WinnerLbl.setIcon(blackwidowWinsIcon);
                    TIME_ENDS = true;

                    ScoreAmountLbl.setText("" + SCORE);
                    ScoreIconLbl.setIcon(scoreIcon);
                    BackLbl.setIcon(backIcon);
                } else {
                    checkBlackwidowHit();

                    if (BLACKWIDOW_HIT) {
                        HULKBAR_NO++;
                    }

                }
            }
        });
        timer2.start();
        timer = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (TIME_ENDS == true) {
                    if (HULKBAR_NO > BLACKWIDOWBAR_NO) {
                        WinnerLbl.setIcon(blackwidowWinsIcon);

                        SCORE = (20 - BLACKWIDOWBAR_NO) * 100;

                        ScoreAmountLbl.setText("" + SCORE);
                        ScoreIconLbl.setIcon(scoreIcon);
                        BackLbl.setIcon(backIcon);

                    } else if (HULKBAR_NO < BLACKWIDOWBAR_NO) {
                        WinnerLbl.setIcon(hulkWinsIcon);

                        SCORE = (20 - HULKBAR_NO) * 100;

                        ScoreAmountLbl.setText("" + SCORE);
                        ScoreIconLbl.setIcon(scoreIcon);
                        BackLbl.setIcon(backIcon);

                    } else {
                        WinnerLbl.setIcon(drawIcon);
                        BackLbl.setIcon(backIcon);
                        SCORE = 0;

                    }
                }

                if (TIME_ENDS == false) {

                    if (W == true && UP == true) {
                        blackwidow.moveBlackWidowUp();
                        hulk.moveHulkUp();

                    } else if (W == true) {
                        blackwidow.moveBlackWidowUp();
                        hulk.moveHulkLeft();
                        hulk.moveHulkRight();
                    } else if (W == true && A == true) {
                        blackwidow.moveBlackWidowUp();
                        hulk.moveHulkLeft();
                        hulk.moveHulkRight();
                    } else if (W == true && D == true) {
                        blackwidow.moveBlackWidowUp();
                        hulk.moveHulkLeft();
                        hulk.moveHulkRight();
                    } else if (UP == true) {
                        hulk.moveHulkUp();
                        blackwidow.blackwidowMoveLeft();
                        blackwidow.blackwidowMoveRight();
                    } else if (UP == true && RIGHT == true) {
                        hulk.moveHulkUp();

                        blackwidow.blackwidowMoveLeft();
                        blackwidow.blackwidowMoveRight();
                    } else if (UP == true && LEFT == true) {
                        hulk.moveHulkUp();
                        blackwidow.blackwidowMoveLeft();
                        blackwidow.blackwidowMoveRight();
                    } else {
                        hulk.moveHulkLeft();
                        hulk.moveHulkRight();
                        blackwidow.blackwidowMoveLeft();
                        blackwidow.blackwidowMoveRight();
                    }

                }
                //checkBlackwidowHit();
                if (BLACKWIDOW_HIT) {
                    if (blackwidow.getImage() == blackwidow.getImage3c() || blackwidow.getImage() == blackwidow.getImage4b()) {
                        hulk.setImage(hulk.getImage0INV());
                        timer_util.schedule(new Hto1I(), 800);
                    } else {
                        hulk.setImage(hulk.getImage0());
                        timer_util.schedule(new Hto1(), 800);
                    }
                    BLACKWIDOW_HIT = false;
                }

                //checkHulkHit();
                if (HULK_HIT) {
                    if (hulk.getImage() == hulk.getImage3b() || hulk.getImage() == hulk.getImage4b()) {
                        blackwidow.setImage(blackwidow.getImage0INV());
                        timer_util.schedule(new Bto1I(), 800);
                    } else {
                        blackwidow.setImage(blackwidow.getImage0());
                        timer_util.schedule(new Bto1(), 800);
                    }
                    HULK_HIT = false;
                }

                repaint();

            }

        });

        timer.start();

        timer4 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                timersphoto.StartCounter();
            }
        });
        timer4.start();

        timer5 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (HULKBAR_NO == 7) {
                    i7++;
                }
                else if (HULKBAR_NO == 14) {
                    i14++;
                } else {
                    hulkAngrySoundPlayed = false;
                }
                if ((i7 == 1 || i14 == 1) && !hulkAngrySoundPlayed) {
                    try {
                        hulkAngrySoundPlayed = true;
                        InputStream in = new FileInputStream("Hulk is Angry.wav");
                        AudioStream audioStream2 = new AudioStream(in);
                        AudioPlayer.player.start(audioStream2);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        );
        timer5.start();

        BackLbl.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {

                try {
                    addScore(SCORE);
                    Arrays.sort(HIGHSCORES);

                    gameFrame.remove(SinglePanel.this);
                    MainMenuPanel mp = new MainMenuPanel();
                    gameFrame.showPanel(mp);

                } catch (IOException ex) {
                    Logger.getLogger(HighScorePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            try {
                hulk.keyReleased(e);
            } catch (IOException ex) {
                Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            try {
                try {
                    hulk.keyPressed(e);

                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void keyTyped(KeyEvent e) {
            try {
                try {
                    hulk.keyTyped(e);

                } catch (InterruptedException ex) {
                    Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(MultiPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void paint(Graphics g) {

        try {
            super.paint(g);
            g.drawImage(blackwidow.getImage(), blackwidow.getX(), blackwidow.getY(), HERO_WIDTH, HERO_HEIGHT, null);
            g.drawImage(hulk.getImage(), hulk.getX(), hulk.getY(), HERO_WIDTH, HERO_HEIGHT, null);

            g.drawImage(hulkhealth.getBar(HULKBAR_NO), (13 * WINDOW_WIDTH) / 480, (11 * WINDOW_HEIGHT) / 360, (609 * WINDOW_WIDTH) / 1920, (164 * WINDOW_HEIGHT) / 1080, null);
            g.drawImage(blackwidowhealth.getBar(BLACKWIDOWBAR_NO), (1259 * WINDOW_WIDTH) / 1920, (11 * WINDOW_HEIGHT) / 360, (609 * WINDOW_WIDTH) / 1920, (164 * WINDOW_HEIGHT) / 1080, null);

            g.drawImage(timersphoto.getRight(), (960 * WINDOW_WIDTH) / 1920, (37 * WINDOW_HEIGHT) / 1080, ((1043 - 960) * WINDOW_WIDTH) / 1920, ((179 - 37) * WINDOW_HEIGHT) / 1080, null);
            g.drawImage(timersphoto.getLeft(), (877 * WINDOW_WIDTH) / 1920, (37 * WINDOW_HEIGHT) / 1080, ((960 - 877) * WINDOW_WIDTH) / 1920, ((179 - 37) * WINDOW_HEIGHT) / 1080, null);

        } catch (Exception e) {

        }

        Toolkit.getDefaultToolkit().sync();

    }

    public void checkBlackwidowHit() {
        if (blackwidow.getImage() == blackwidow.getImage3c() && hulk.getX() - blackwidow.getX() <= (220 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            BLACKWIDOW_HIT = true;

        } else if (blackwidow.getImage() == blackwidow.getImage3cINV() && blackwidow.getX() - hulk.getX() <= (220 * WINDOW_WIDTH) / 1920 && blackwidow.getX() - hulk.getX() > 0) {
            BLACKWIDOW_HIT = true;
        } else if (blackwidow.getImage() == blackwidow.getImage4b() && hulk.getX() - blackwidow.getX() <= (223 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            BLACKWIDOW_HIT = true;

        } else if (blackwidow.getImage() == blackwidow.getImage4bINV() && blackwidow.getX() - hulk.getX() <= (223 * WINDOW_WIDTH) / 1920 && blackwidow.getX() - hulk.getX() > 0) {
            BLACKWIDOW_HIT = true;

        } else if (blackwidow.getImage() == blackwidow.getImage4b() && hulk.getImage() == hulk.getImage1() && hulk.getX() - blackwidow.getX() <= (290 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            BLACKWIDOW_HIT = true;
        } else if (blackwidow.getImage() == blackwidow.getImage4bINV() && hulk.getImage() == hulk.getImage1INV() && hulk.getX() - blackwidow.getX() <= (290 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            BLACKWIDOW_HIT = true;
        } else if (blackwidow.getImage() == blackwidow.getImage3bINV() && hulk.getImage() == hulk.getImage1INV() && blackwidow.getX() - hulk.getX() <= (290 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            BLACKWIDOW_HIT = true;
        } else if (blackwidow.getImage() == blackwidow.getImage3b() && hulk.getImage() == hulk.getImage1() && (hulk.getX() - blackwidow.getX() <= (290 * WINDOW_WIDTH) / 1920) && hulk.getX() - blackwidow.getX() > 0) {
            BLACKWIDOW_HIT = true;
        }
    }

    public boolean inRange() {
        if (hulk.getX() - blackwidow.getX() <= (220 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            return true;
        } else if (blackwidow.getX() - hulk.getX() <= (220 * WINDOW_WIDTH) / 1920 && blackwidow.getX() - hulk.getX() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void checkHulkHit() {

        if (hulk.getImage() == hulk.getImage3b() && blackwidow.getX() - hulk.getX() <= (270 * WINDOW_WIDTH) / 1920 && blackwidow.getX() - hulk.getX() > 0) {

            HULK_HIT = true;

        } else if (hulk.getImage() == hulk.getImage3bINV() && hulk.getX() - blackwidow.getX() <= (270 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            HULK_HIT = true;
        } else if (hulk.getImage() == hulk.getImage4b() && blackwidow.getX() - hulk.getX() <= (315 * WINDOW_WIDTH) / 1920 && blackwidow.getX() - hulk.getX() > 0) {
            HULK_HIT = true;

        } else if (hulk.getImage() == hulk.getImage4bINV() && hulk.getX() - blackwidow.getX() <= (315 * WINDOW_WIDTH) / 1920 && hulk.getX() - blackwidow.getX() > 0) {
            HULK_HIT = true;

        }

    }

    class Hto1 extends TimerTask {

        public void run() {
            hulk.setImage(hulk.getImage1());
        }
    }

    class Hto1I extends TimerTask {

        public void run() {
            hulk.setImage(hulk.getImage1INV());
        }
    }

    class Bto1 extends TimerTask {

        public void run() {
            blackwidow.setImage(blackwidow.getImage1());

        }
    }

    class Bto1I extends TimerTask {

        public void run() {
            blackwidow.setImage(blackwidow.getImage1INV());

        }
    }
}

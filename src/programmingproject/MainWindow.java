package programmingproject;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import static programmingproject.ProgrammingProject.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MainWindow extends JFrame {

    private JLabel logoLbl;
    private JLabel singlePlayerLbl;
    private JLabel multiPlayerLbl;
    private JLabel highScoresLbl;
    private JLabel optionsLbl;
    private JLabel exitLbl;

    private JPanel holderPnl;

    private ImageIcon logoIcon;
    private ImageIcon singlePlayerIcon;
    private ImageIcon multiPlayerIcon;
    private ImageIcon highScoresIcon;
    private ImageIcon optionsIcon;
    private ImageIcon exitIcon;

    private ImageIcon singlePlayerIcon_enlarged;
    private ImageIcon multiPlayerIcon_enlarged;
    private ImageIcon optionsIcon_enlarged;
    private ImageIcon highScoresIcon_enlarged;
    private ImageIcon exitIcon_enlarged;

    public MainWindow() throws IOException, FileNotFoundException {
        DisplayMode dm = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeLabels();

        InputStream in = new FileInputStream("Drake_-_Trophies.wav");
        AudioStream audioStream2 = new AudioStream(in);
        AudioPlayer.player.start(audioStream2);

        this.setContentPane(new JLabel(new ImageIcon("Background_MainWindow.jpg")));

        Container c = this.getContentPane();
        c.setLayout(null);

//         
        logoLbl.setBounds((5 * WINDOW_WIDTH) / 64, (5 * WINDOW_HEIGHT) / 216, 310, 250);

        singlePlayerLbl.setBounds(WINDOW_WIDTH / 24, (18 * WINDOW_HEIGHT) / 54, 453, 75);

        multiPlayerLbl.setBounds((13 * WINDOW_WIDTH) / 240, (249 * WINDOW_HEIGHT) / 540, 420, 70);

        highScoresLbl.setBounds((59 * WINDOW_WIDTH) / 960, (127 * WINDOW_HEIGHT) / 216, 392, 75);

        optionsLbl.setBounds((158 * WINDOW_WIDTH) / 1920, (753 * WINDOW_HEIGHT) / 1080, 316, 74);

        exitLbl.setBounds((227 * WINDOW_WIDTH) / 1920, (91 * WINDOW_HEIGHT) / 108, 170, 65);

        singlePlayerLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    AudioPlayer.player.stop(audioStream2);
                    InputStream in = new FileInputStream("Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    //GameBoard gb = new GameBoard();
                    SelectMap sm = new SelectMap();

                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    singlePlayerLbl.setIcon(singlePlayerIcon_enlarged);
                    InputStream in = new FileInputStream("Menu_Mouse_Entered.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

            @Override
            public void mouseExited(MouseEvent e2) {

                try {
                    singlePlayerLbl.setIcon(singlePlayerIcon);

                    InputStream in = new FileInputStream("Menu_Mouse_Exited.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

        });

        multiPlayerLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    AudioPlayer.player.stop(audioStream2);
                    InputStream in = new FileInputStream("Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    //GameBoard gb = new GameBoard();
                    SelectMap_Multi sm = new SelectMap_Multi();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    multiPlayerLbl.setIcon(multiPlayerIcon_enlarged);
                    InputStream in = new FileInputStream("Menu_Mouse_Entered.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

            @Override
            public void mouseExited(MouseEvent e2) {

                try {
                    multiPlayerLbl.setIcon(multiPlayerIcon);

                    InputStream in = new FileInputStream("Menu_Mouse_Exited.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

        });

        optionsLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    AudioPlayer.player.stop(audioStream2);
                    InputStream in = new FileInputStream("Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    ViewControls vc = new ViewControls();
                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    optionsLbl.setIcon(optionsIcon_enlarged);
                    InputStream in = new FileInputStream("Menu_Mouse_Entered.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

            @Override
            public void mouseExited(MouseEvent e2) {

                try {
                    optionsLbl.setIcon(optionsIcon);

                    InputStream in = new FileInputStream("Menu_Mouse_Exited.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

        });

        highScoresLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    AudioPlayer.player.stop(audioStream2);
                    InputStream in = new FileInputStream("Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    HighScoreWindow hsw = new HighScoreWindow();

                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    highScoresLbl.setIcon(highScoresIcon_enlarged);
                    InputStream in = new FileInputStream("Menu_Mouse_Entered.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

            @Override
            public void mouseExited(MouseEvent e2) {

                try {
                    highScoresLbl.setIcon(highScoresIcon);

                    InputStream in = new FileInputStream("Menu_Mouse_Exited.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

        });

        exitLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    AudioPlayer.player.stop(audioStream2);
                    InputStream in = new FileInputStream("Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);

                    HighScoreTxt.clear();
                    HighScoreTxt.Save();
                    System.exit(0);

                } catch (IOException ex) {
                    Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    exitLbl.setIcon(exitIcon_enlarged);
                    InputStream in = new FileInputStream("Menu_Mouse_Entered.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

            @Override
            public void mouseExited(MouseEvent e2) {

                try {
                    exitLbl.setIcon(exitIcon);

                    InputStream in = new FileInputStream("Menu_Mouse_Exited.wav");

                    // create an audiostream from the inputstream
                    AudioStream audioStream = new AudioStream(in);

                    // play the audio clip with the audioplayer class
                    AudioPlayer.player.start(audioStream);
                    //AudioPlayer.player.stop(audioStream);

                } catch (Exception ex) {
                    System.out.println("Error with playing sound.");
                    ex.printStackTrace();

                }
            }

        });

        c.add(logoLbl);
        c.add(singlePlayerLbl);
        c.add(multiPlayerLbl);
        c.add(highScoresLbl);
        c.add(optionsLbl);
        c.add(exitLbl);
        Screen s = new Screen();

        try {
            s.setFullScreen(dm, this);

        } catch (Exception e) {

            System.out.println("Exception in setting MainWindow to full screen mode");
            this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        }

        this.setVisible(true);
    }

    private void initializeLabels() {

        logoLbl = new JLabel();
        try {
            logoIcon = new ImageIcon("Logo.png");
            logoLbl.setIcon(logoIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading logoIcon");
        }

        singlePlayerLbl = new JLabel();
        try {
            singlePlayerIcon = new ImageIcon("SinglePlayer.png");
            singlePlayerLbl.setIcon(singlePlayerIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading singlePlayerIcon");
        }

        multiPlayerLbl = new JLabel();
        try {
            multiPlayerIcon = new ImageIcon("MultiPlayer.png");
            multiPlayerLbl.setIcon(multiPlayerIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading multiPlayerIcon");
        }

        highScoresLbl = new JLabel();
        try {
            highScoresIcon = new ImageIcon("HighScores.png");
            highScoresLbl.setIcon(highScoresIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading highScoresIcon");
        }

        optionsLbl = new JLabel();
        try {
            optionsIcon = new ImageIcon("Options.png");
            optionsLbl.setIcon(optionsIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading optionsIcon");
        }

        exitLbl = new JLabel();
        try {
            exitIcon = new ImageIcon("Exit.png");
            exitLbl.setIcon(exitIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading exitIcon");
        }

        singlePlayerIcon_enlarged = new ImageIcon("Single2.png");
        multiPlayerIcon_enlarged = new ImageIcon("Mult2.png");
        highScoresIcon_enlarged = new ImageIcon("HighScores2.png");
        optionsIcon_enlarged = new ImageIcon("Options2.png");
        exitIcon_enlarged = new ImageIcon("EXIT2.png");

    }

//     @Override
//    public void paint (Graphics g){
//        super.paint(g);
//        try{
//        Image img = ImageIO.read(new File("Background_MainWindow.jpg"));
//        g.drawImage(img, 0, 0,getWidth(),getHeight(), null);
//
//        }
//        catch(Exception e ){}
//       
//         
//        
//    
//    }
}

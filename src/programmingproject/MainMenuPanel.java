package programmingproject;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static programmingproject.ProgrammingProject.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.JFXPanel;

public class MainMenuPanel extends JPanel {

    private JLabel backgroundLbl;
    private JLabel logoLbl;
    private JLabel singlePlayerLbl;
    private JLabel multiPlayerLbl;
    private JLabel highScoresLbl;
    private JLabel viewControlsLbl;
    private JLabel exitLbl;

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
    public static boolean multi;

    public MainMenuPanel() throws IOException, FileNotFoundException {

        initializeLabels();

        // play main menu song
        final JFXPanel fxPanel = new JFXPanel();
        String bip = "src/resources/1.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        setLayout(null);

        backgroundLbl.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        logoLbl.setBounds((5 * WINDOW_WIDTH) / 64, (5 * WINDOW_HEIGHT) / 216, 310, 250);

        singlePlayerLbl.setBounds(WINDOW_WIDTH / 24, (18 * WINDOW_HEIGHT) / 54, 453, 75);

        multiPlayerLbl.setBounds((13 * WINDOW_WIDTH) / 240, (249 * WINDOW_HEIGHT) / 540, 420, 70);

        highScoresLbl.setBounds((59 * WINDOW_WIDTH) / 960, (127 * WINDOW_HEIGHT) / 216, 392, 75);

        viewControlsLbl.setBounds((158 * WINDOW_WIDTH) / 1920, (753 * WINDOW_HEIGHT) / 1080, 316, 74);

        exitLbl.setBounds((227 * WINDOW_WIDTH) / 1920, (91 * WINDOW_HEIGHT) / 108, 170, 65);

        singlePlayerLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                multi = false;
                try {
                    InputStream in = new FileInputStream("src/resources/Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    setVisible(false);
                    SelectMap sm = new SelectMap();
                    gameFrame.showPanel(sm);

                } catch (IOException ex) {
                    Logger.getLogger(MainMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    singlePlayerLbl.setIcon(singlePlayerIcon_enlarged);
                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Entered.wav");

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

                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Exited.wav");

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
                multi = true;
                try {
                    InputStream in = new FileInputStream("src/resources/Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    setVisible(false);
                    SelectMap sm = new SelectMap();
                    gameFrame.showPanel(sm);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    multiPlayerLbl.setIcon(multiPlayerIcon_enlarged);
                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Entered.wav");

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

                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Exited.wav");

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

        viewControlsLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                    InputStream in = new FileInputStream("src/resources/Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    ViewControls vc = new ViewControls();
                    setVisible(false);
                    gameFrame.showPanel(vc);
                } catch (IOException ex) {
                    Logger.getLogger(MainMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    viewControlsLbl.setIcon(optionsIcon_enlarged);
                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Entered.wav");

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
                    viewControlsLbl.setIcon(optionsIcon);

                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Exited.wav");

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
                    InputStream in = new FileInputStream("src/resources/Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);
                    HighScorePanel hsw = new HighScorePanel();
                    setVisible(false);
                    gameFrame.showPanel(hsw);

                } catch (IOException ex) {
                    Logger.getLogger(MainMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    highScoresLbl.setIcon(highScoresIcon_enlarged);
                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Entered.wav");

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

                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Exited.wav");

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
                    InputStream in = new FileInputStream("src/resources/Menu_Select.wav");
                    AudioStream audioStream = new AudioStream(in);
                    AudioPlayer.player.start(audioStream);

                    HighScoreTxt.clear();
                    HighScoreTxt.Save();
                    System.exit(0);

                } catch (IOException ex) {
                    Logger.getLogger(MainMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e1) {
                try {

                    exitLbl.setIcon(exitIcon_enlarged);
                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Entered.wav");

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

                    InputStream in = new FileInputStream("src/resources/Menu_Mouse_Exited.wav");

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

        add(logoLbl);
        add(singlePlayerLbl);
        add(multiPlayerLbl);
        add(highScoresLbl);
        add(viewControlsLbl);
        add(exitLbl);
        add(backgroundLbl);

    }

    private void initializeLabels() {

        logoLbl = new JLabel();
        try {
            logoIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/Logo.png"));
            logoLbl.setIcon(logoIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading logoIcon");
        }

        singlePlayerLbl = new JLabel();
        try {
            singlePlayerIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/SinglePlayer.png"));
            singlePlayerLbl.setIcon(singlePlayerIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading singlePlayerIcon");
        }

        multiPlayerLbl = new JLabel();
        try {
            multiPlayerIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/MultiPlayer.png"));
            multiPlayerLbl.setIcon(multiPlayerIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading multiPlayerIcon");
        }

        highScoresLbl = new JLabel();
        try {
            highScoresIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/HighScores.png"));
            highScoresLbl.setIcon(highScoresIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading highScoresIcon");
        }

        viewControlsLbl = new JLabel();
        try {
            optionsIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/Options.png"));
            viewControlsLbl.setIcon(optionsIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading optionsIcon");
        }

        exitLbl = new JLabel();
        try {
            exitIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/EXIT.png"));
            exitLbl.setIcon(exitIcon);
        } catch (Exception e) {
            System.out.println("Exception in loading exitIcon");
        }
        backgroundLbl = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("resources/Background_MainWindow.jpg")));
        singlePlayerIcon_enlarged = new ImageIcon(getClass().getClassLoader().getResource("resources/Single2.png"));
        multiPlayerIcon_enlarged = new ImageIcon(getClass().getClassLoader().getResource("resources/Mult2.png"));
        highScoresIcon_enlarged = new ImageIcon(getClass().getClassLoader().getResource("resources/HighScores2.png"));
        optionsIcon_enlarged = new ImageIcon(getClass().getClassLoader().getResource("resources/Options2.png"));
        exitIcon_enlarged = new ImageIcon(getClass().getClassLoader().getResource("resources/EXIT2.png"));

    }
}

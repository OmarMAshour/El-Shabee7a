package programmingproject;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Omar Ashour
 */
public class ProgrammingProject {

    public static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static final int HERO_WIDTH = (319 * WINDOW_WIDTH) / 960;
    public static final int HERO_HEIGHT = (287 * WINDOW_HEIGHT) / 540;
    public static boolean RIGHT = false;
    public static boolean LEFT = false;
    public static boolean UP = false;
    public static boolean W = false;
    public static boolean A = false;
    public static boolean D = false;
    public static boolean ONE = false;
    public static boolean TWO = false;
    public static boolean BLACKWIDOW_HIT = false;
    public static boolean HULK_HIT = false;
    public static boolean TIME_ENDS = false;
    public static int TIME_COUNTER = 0;
    public static int SCORE = 0;
    public static int[] HIGHSCORES = new int[1000];
    public static boolean ASU_BACKGROUND = false;
    public static int HULKBAR_NO = 0;
    public static int BLACKWIDOWBAR_NO = 0;
    public static GameFrame gameFrame;

    public static void addScore(int score) {

        for (int i = 0; i < HIGHSCORES.length; i++) {
            if (HIGHSCORES[i] == 0) {
                HIGHSCORES[i] = SCORE;
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        HighScoreTxt.Load();
        Arrays.sort(HIGHSCORES);
        System.out.println(WINDOW_WIDTH + " x " + WINDOW_HEIGHT);
        gameFrame = new GameFrame();
    }
}

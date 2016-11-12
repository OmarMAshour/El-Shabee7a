/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingproject;

import static programmingproject.ProgrammingProject.*;
import java.util.TimerTask;
import java.util.Timer;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Timers {

    private int R;
    private int L;
    private final Image[] RightCounter = new Image[10];
    private final Image[] LeftCounter = new Image[7];
    Timer timer;

    private Image RightTemp = null;
    public Image LeftTemp = null;
    int c;

    public Timers() throws IOException {
        RightCounter[0] = LeftCounter[0] = ImageIO.read(new File("0.png"));
        RightCounter[1] = LeftCounter[1] = ImageIO.read(new File("1.png"));
        RightCounter[2] = LeftCounter[2] = ImageIO.read(new File("2.png"));
        RightCounter[3] = LeftCounter[3] = ImageIO.read(new File("3.png"));
        RightCounter[4] = LeftCounter[4] = ImageIO.read(new File("4.png"));
        RightCounter[5] = LeftCounter[5] = ImageIO.read(new File("5.png"));
        RightCounter[6] = LeftCounter[6] = ImageIO.read(new File("6.png"));
        RightCounter[7] = ImageIO.read(new File("7.png"));
        RightCounter[8] = ImageIO.read(new File("8.png"));
        RightCounter[9] = ImageIO.read(new File("9.png"));
        RightTemp = ImageIO.read(new File("0.png"));
        LeftTemp = ImageIO.read(new File("6.png"));

        R = 0;
        L = 6;

    }

    public Image getRight() {
        return RightTemp;
    }

    public Image getLeft() {
        return LeftTemp;
    }

    public void setTimerImage() {
        
        if(TIME_ENDS == false){
        if (getRight() == RightCounter[0] && getLeft() == LeftCounter[0]) {

            R = 0;
            L = 0;
            TIME_ENDS = true;
        } else if (R != 0) {
            RightTemp = RightCounter[--R];
            TIME_COUNTER++;

        } else {
            LeftTemp = LeftCounter[--L];
            R = 9;
            RightTemp = RightCounter[9];
            TIME_COUNTER++;

        }
        }
    }

    public void StartCounter() {
        timer = new Timer();
        timer.schedule(new timerdelay(), 1000);
    }

    class timerdelay extends TimerTask {

        public void run() {
            setTimerImage();
        }
    }

}

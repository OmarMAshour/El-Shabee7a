package programmingproject;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import static programmingproject.ProgrammingProject.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BlackWidow {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int blackwidowMotioncount;
    private int blackwidowstate;

    private Image temp = null;

    private Image blackwidowImage0;
    private Image blackwidowImage1;
    private Image blackwidowImage2a;
    private Image blackwidowImage2b;
    private Image blackwidowImage3a;
    private Image blackwidowImage3b;
    private Image blackwidowImage3c;
    private Image blackwidowImage4a;
    private Image blackwidowImage4b;
    private Image blackwidowImage5a;
    private Image blackwidowImage5b;
    private Image blackwidowImage5c;

    private Image blackwidowImage0INV;
    private Image blackwidowImage1INV;
    private Image blackwidowImage2aINV;
    private Image blackwidowImage2bINV;
    private Image blackwidowImage3aINV;
    private Image blackwidowImage3bINV;
    private Image blackwidowImage3cINV;
    private Image blackwidowImage4aINV;
    private Image blackwidowImage4bINV;
    private Image blackwidowImage5aINV;
    private Image blackwidowImage5bINV;
    private Image blackwidowImage5cINV;

    private int BlackWidowFall = 0;
    private java.util.Timer timer;

    public BlackWidow(int x, int y) throws IOException {

        this.x = x;
        this.y = y;

        dx = 0;
        dy = 0;

        blackwidowstate = 0;
        blackwidowMotioncount = 0;

        blackwidowImage0 = ImageIO.read(new File("BW_0.png"));
        blackwidowImage1 = ImageIO.read(new File("BW_1.png"));
        blackwidowImage2a = ImageIO.read(new File("BW_2a.png"));
        blackwidowImage2b = ImageIO.read(new File("BW_2b.png"));
        blackwidowImage3a = ImageIO.read(new File("BW_3a.png"));
        blackwidowImage3b = ImageIO.read(new File("BW_3b.png"));
        blackwidowImage3c = ImageIO.read(new File("BW_3c.png"));
        blackwidowImage4a = ImageIO.read(new File("BW_4a.png"));
        blackwidowImage4b = ImageIO.read(new File("BW_4b.png"));
        blackwidowImage5a = ImageIO.read(new File("BW_5a.png"));
        blackwidowImage5b = ImageIO.read(new File("BW_5b.png"));
        blackwidowImage5c = ImageIO.read(new File("BW_5c.png"));

        blackwidowImage0INV = ImageIO.read(new File("BW_INV_0.png"));
        blackwidowImage1INV = ImageIO.read(new File("BW_INV_1.png"));
        blackwidowImage2aINV = ImageIO.read(new File("BW_INV_2a.png"));
        blackwidowImage2bINV = ImageIO.read(new File("BW_INV_2b.png"));
        blackwidowImage3aINV = ImageIO.read(new File("BW_INV_3a.png"));
        blackwidowImage3bINV = ImageIO.read(new File("BW_INV_3b.png"));
        blackwidowImage3cINV = ImageIO.read(new File("BW_INV_3c.png"));
        blackwidowImage4aINV = ImageIO.read(new File("BW_INV_4a.png"));
        blackwidowImage4bINV = ImageIO.read(new File("BW_INV_4b.png"));
        blackwidowImage5aINV = ImageIO.read(new File("BW_INV_5a.png"));
        blackwidowImage5bINV = ImageIO.read(new File("BW_INV_5b.png"));
        blackwidowImage5cINV = ImageIO.read(new File("BW_INV_5c.png"));

        temp = blackwidowImage1INV;

    }

    public void move() {
        if (W == false) {
            x += dx;
        } else if (W == true && x < (WINDOW_WIDTH - HERO_WIDTH) && x > 0) {
            if ((y < WINDOW_HEIGHT / 2) && ((y + HERO_HEIGHT) < WINDOW_HEIGHT)) {
                x += dx;
                y += dy;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getdX() {
        return dx;
    }

    public int getdY() {
        return dy;
    }

    public Image getImage() {
        return temp;
    }

    public Image getImage0() {
        return blackwidowImage0;
    }

    public Image getImage1() {
        return blackwidowImage1;
    }

    public Image getImage2a() {
        return blackwidowImage2a;
    }

    public Image getImage2b() {
        return blackwidowImage2b;
    }

    public Image getImage3a() {
        return blackwidowImage3a;
    }

    public Image getImage3b() {
        return blackwidowImage3b;
    }

    public Image getImage3c() {
        return blackwidowImage3c;
    }

    public Image getImage4a() {
        return blackwidowImage4a;
    }

    public Image getImage4b() {
        return blackwidowImage4b;
    }

    public Image getImage0INV() {
        return blackwidowImage0INV;
    }

    public Image getImage1INV() {
        return blackwidowImage1INV;
    }

    public Image getImage2aINV() {
        return blackwidowImage2aINV;
    }

    public Image getImage2bINV() {
        return blackwidowImage2bINV;
    }

    public Image getImage3aINV() {
        return blackwidowImage3aINV;
    }

    public Image getImage3bINV() {
        return blackwidowImage3bINV;
    }

    public Image getImage3cINV() {
        return blackwidowImage3cINV;
    }

    public Image getImage4aINV() {
        return blackwidowImage4aINV;
    }

    public Image getImage4bINV() {
        return blackwidowImage4bINV;
    }

    public void setX(int x) {
        this.x = x;

    }

    public void setY(int y) {
        this.y = y;
    }

    public void setdX(int dx) {
        this.dx = dx;
    }

    public void setdY(int dy) {
        this.dy = dy;
    }

    public void setImage(Image blackwidow) {
        temp = blackwidow;
    }

    private boolean hitting() {
        if (getImage() == blackwidowImage1 || getImage() == blackwidowImage1INV || getImage() == blackwidowImage2a || getImage() == blackwidowImage2b || getImage() == blackwidowImage2aINV || getImage() == blackwidowImage2bINV) {
            return false;
        } else {
            return true;
        }
    }

    public void moveBlackWidowUp() {
        if (W == true && (!hitting())) {
            setImage(blackwidowImage5a);
            this.blackwidowMotioncount += 10;
            if (this.blackwidowMotioncount % 50 == 0) {

                blackwidowMotioncount = 0;

                if (BlackWidowFall <= 15) {
                    dy = -20;
                    move();
                } else if (BlackWidowFall >= 16 && BlackWidowFall < 32) {
                    dy = 20;
                    move();
                }

                if (BlackWidowFall >= 33) {
                    dy = 0;
                    move();
                }
                BlackWidowFall++;
            }
        }

        if (W == true && D == true) {
            setImage(blackwidowImage5a);

            if ((y > (WINDOW_HEIGHT / 2) - 150)) {
                this.blackwidowMotioncount += 10;
                if (this.blackwidowMotioncount % 50 == 0) {

                    blackwidowMotioncount = 0;

                    if (BlackWidowFall <= 15) {
                        dy = -20;
                        dx = 20;
                        move();
                    } else if (BlackWidowFall >= 16 && BlackWidowFall < 32) {
                        dy = 20;
                        dx = 20;
                        move();
                    }

                    if (BlackWidowFall >= 33) {
                        dy = 0;
                        move();
                    }
                    BlackWidowFall++;
                }
            }
        }
        if (W == true && A == true) {
            setImage(blackwidowImage5aINV);
            if ((y > (WINDOW_HEIGHT / 2) - 150)) {
                this.blackwidowMotioncount += 10;
                if (this.blackwidowMotioncount % 10 == 0) {

                    blackwidowMotioncount = 0;

                    if (BlackWidowFall <= 15) {
                        dy = -20;
                        dx = -20;
                        move();
                    } else if (BlackWidowFall >= 16 && BlackWidowFall <= 32) {
                        dy = 20;
                        dx = -20;
                        move();
                    }

                    if (BlackWidowFall >= 33) {
                        dy = 0;
                        dx = 0;
                        move();
                    }
                    BlackWidowFall++;
                }
                BlackWidowFall = 0;

            }

        }
    }

    public void blackwidowMoveLeft() {
        if (A == true && (!hitting())) {
            if ((x - 10) <= (0)) {

                if (this.blackwidowMotioncount == 0) {
                    dx = 0;
                    if (this.blackwidowstate == 0) {
                        this.blackwidowstate = 1;
                    } else if (this.blackwidowstate == 1) {
                        this.blackwidowstate = 2;
                    } else if (this.blackwidowstate == 2) {
                        this.blackwidowstate = 1;
                    }
                }

                switch (this.blackwidowstate) {
                    case 0:
                        setImage(blackwidowImage1INV);
                        break;
                    case 1:
                        setImage(blackwidowImage2aINV);
                        break;
                    case 2:
                        setImage(blackwidowImage2bINV);
                        break;
                }

                this.blackwidowMotioncount += 10;
                if (this.blackwidowMotioncount % 170 == 0) {
                    blackwidowMotioncount = 0;

                }

            } else {
                if (this.blackwidowMotioncount == 0) {
                    dx = -4;
                    if (this.blackwidowstate == 0) {
                        this.blackwidowstate = 1;
                    } else if (this.blackwidowstate == 1) {
                        this.blackwidowstate = 2;
                    } else if (this.blackwidowstate == 2) {
                        this.blackwidowstate = 1;
                    }
                }

                switch (this.blackwidowstate) {
                    case 0:
                        setImage(blackwidowImage1INV);

                        break;
                    case 1:
                        setImage(blackwidowImage2aINV);
                        break;
                    case 2:
                        setImage(blackwidowImage2bINV);
                        break;
                }

                this.blackwidowMotioncount += 10;
                if (this.blackwidowMotioncount % 170 == 0) {
                    blackwidowMotioncount = 0;
                }
            }
            move();
        }
    }

    public void blackwidowMoveRight() {
        if (D == true && (!hitting())) {
            if ((x + 10) >= (WINDOW_WIDTH - HERO_WIDTH)) {

                if (this.blackwidowMotioncount == 0) {
                    dx = 0;
                    if (this.blackwidowstate == 0) {
                        this.blackwidowstate = 1;
                    } else if (this.blackwidowstate == 1) {
                        this.blackwidowstate = 2;
                    } else if (this.blackwidowstate == 2) {
                        this.blackwidowstate = 1;
                    }
                }

                switch (this.blackwidowstate) {
                    case 0:
                        setImage(blackwidowImage1);
                        break;
                    case 1:
                        setImage(blackwidowImage2a);
                        break;
                    case 2:
                        setImage(blackwidowImage2b);
                        break;
                }

                this.blackwidowMotioncount += 10;
                if (this.blackwidowMotioncount % 170 == 0) {
                    blackwidowMotioncount = 0;

                }

            } else {
                if (this.blackwidowMotioncount == 0) {
                    dx = 4;
                    if (this.blackwidowstate == 0) {
                        this.blackwidowstate = 1;
                    } else if (this.blackwidowstate == 1) {
                        this.blackwidowstate = 2;
                    } else if (this.blackwidowstate == 2) {
                        this.blackwidowstate = 1;
                    }
                }

                switch (this.blackwidowstate) {
                    case 0:
                        setImage(blackwidowImage1);
                        break;
                    case 1:
                        setImage(blackwidowImage2a);
                        break;
                    case 2:
                        setImage(blackwidowImage2b);
                        break;
                }

                this.blackwidowMotioncount += 10;
                if (this.blackwidowMotioncount % 170 == 0) {
                    blackwidowMotioncount = 0;
                }
            }
            move();

        }
    }

    public void keyPressed(KeyEvent e) throws IOException, InterruptedException {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W && TIME_ENDS == false) {
            W = true;

        }
        if (key == KeyEvent.VK_A && TIME_ENDS == false) {

            A = true;
        }

        //--------------------------------------------------------------
        if (key == KeyEvent.VK_D && TIME_ENDS == false) {

            D = true;
        }
    }

    public void keyReleased(KeyEvent e) throws IOException {

        int key = e.getKeyCode();
        this.blackwidowstate = 0;
        this.blackwidowMotioncount = 0;

        if (key == KeyEvent.VK_W && TIME_ENDS == false) {
            W = false;
            BlackWidowFall = 0;
            y = (4 * WINDOW_HEIGHT) / 9;
            D = false;
            A = false;
            if (getImage() == blackwidowImage5aINV) {
                setImage(blackwidowImage1INV);
            } else {
                setImage(blackwidowImage1);
            }
        }
        if (key == KeyEvent.VK_A && TIME_ENDS == false) {
            A = false;
            dx = 0;
            if (!hitting()) {
                setImage(blackwidowImage1INV);
            }
        } else if (key == KeyEvent.VK_D && TIME_ENDS == false) {
            D = false;
            dx = 0;
            if (!hitting()) {
                setImage(blackwidowImage1);
            }
        }
    }

    public void hit1() throws FileNotFoundException, IOException {
        timer = new java.util.Timer();
        D = false;
        A = false;
        if (getImage() == blackwidowImage1 || getImage() == blackwidowImage2a || getImage() == blackwidowImage2b) {
            setImage(blackwidowImage4a);
            InputStream in = new FileInputStream("FemaleAttack.wav");
            AudioStream audioStream2 = new AudioStream(in);
            AudioPlayer.player.start(audioStream2);
            timer.schedule(new to4b(), 500);
            timer.schedule(new to1(), 1000);
        } else if (getImage() == blackwidowImage1INV || getImage() == blackwidowImage2aINV || getImage() == blackwidowImage2bINV) {
            setImage(blackwidowImage4aINV);
            InputStream in = new FileInputStream("FemaleAttack.wav");
            AudioStream audioStream2 = new AudioStream(in);
            AudioPlayer.player.start(audioStream2);
            timer.schedule(new to4bI(), 500);
            timer.schedule(new to1I(), 1000);
        }
    }

    public void hit2() {
        timer = new java.util.Timer();
        D = false;
        A = false;
        if (getImage() == blackwidowImage1 || getImage() == blackwidowImage2a || getImage() == blackwidowImage2b) {
            setImage(blackwidowImage3a);
            timer.schedule(new to3b(), 500);
            timer.schedule(new to3c(), 1000);
            timer.schedule(new to1(), 1500);
        } else if (getImage() == blackwidowImage1INV || getImage() == blackwidowImage2aINV || getImage() == blackwidowImage2bINV) {
            timer = new java.util.Timer();
            setImage(blackwidowImage3aINV);
            timer.schedule(new to3bI(), 500);
            timer.schedule(new to3cI(), 750);
            timer.schedule(new to1I(), 1500);
        }
    }

    public void keyTyped(KeyEvent e) throws IOException, InterruptedException {
        if (TIME_ENDS == false) {
            if (e.getKeyChar() == '1') {
                hit1();
            } else if (e.getKeyChar() == '2') {
                hit2();
            }
        }
    }

    class to3b extends TimerTask {

        public void run() {
            setImage(blackwidowImage3b);
        }
    }

    class to3bI extends TimerTask {

        public void run() {
            setImage(blackwidowImage3bINV);
        }
    }

    class to3c extends TimerTask {

        public void run() {
            setImage(blackwidowImage3c);
        }
    }

    class to3cI extends TimerTask {

        public void run() {
            setImage(blackwidowImage3cINV);
        }
    }

    class to1 extends TimerTask {

        public void run() {
            setImage(blackwidowImage1);
        }
    }

    class to1I extends TimerTask {

        public void run() {
            setImage(blackwidowImage1INV);
        }
    }

    class to4b extends TimerTask {

        public void run() {
            setImage(blackwidowImage4b);
        }
    }

    class to4bI extends TimerTask {

        public void run() {
            setImage(blackwidowImage4bINV);
        }
    }
}

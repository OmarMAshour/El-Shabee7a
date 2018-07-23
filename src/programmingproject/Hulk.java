package programmingproject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import static programmingproject.ProgrammingProject.*;
import java.util.Timer;
import java.util.TimerTask;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Hulk {

    private int x;
    private int y;
    private int dx;
    private int dy;
    private int hulkMotioncount;
    private int hulkstate;
    //0 standing 1 motion1 2 motion2

    private final Image hulkImage0;
    private final Image hulkImage1;
    private final Image hulkImage2a;
    private final Image hulkImage2b;
    private final Image hulkImage3a;
    private final Image hulkImage3b;
    private final Image hulkImage3c;
    private final Image hulkImage4a;
    private final Image hulkImage4b;
    private Image temp = null;

    private final Image hulkImage0INV;
    private final Image hulkImage1INV;
    private final Image hulkImage2aINV;
    private final Image hulkImage2bINV;
    private final Image hulkImage3aINV;
    private final Image hulkImage3bINV;
    private final Image hulkImage3cINV;
    private final Image hulkImage4aINV;
    private final Image hulkImage4bINV;
    Timer timer;
    private int HulkFall = 0;

    public Hulk(int x, int y) throws IOException {

        this.x = x;
        this.y = y;
        this.hulkstate = 0;
        hulkMotioncount = 0;

        hulkImage0 = ImageIO.read(new File("HULK_0.png"));

        hulkImage2a = ImageIO.read(new File("HULK_2a.png"));
        hulkImage2b = ImageIO.read(new File("HULK_2b.png"));
        hulkImage1 = ImageIO.read(new File("HULK_1a.png"));
        hulkImage3a = ImageIO.read(new File("HULK_3a.png"));
        hulkImage3b = ImageIO.read(new File("HULK_3b.png"));
        hulkImage3c = ImageIO.read(new File("HULK_3c.png"));
        hulkImage4a = ImageIO.read(new File("HULK_4a.png"));
        hulkImage4b = ImageIO.read(new File("HULK_4b.png"));

        temp = hulkImage1;

        hulkImage0INV = ImageIO.read(new File("HULK_0_inv.png"));
        hulkImage1INV = ImageIO.read(new File("HULK_1a_inv.png"));
        hulkImage2aINV = ImageIO.read(new File("HULK_2a_inv.png"));
        hulkImage2bINV = ImageIO.read(new File("HULK_2b_inv.png"));
        hulkImage3aINV = ImageIO.read(new File("HULK_3a_inv.png"));
        hulkImage3bINV = ImageIO.read(new File("HULK_3b_inv.png"));
        hulkImage3cINV = ImageIO.read(new File("HULK_3c_inv.png"));
        hulkImage4aINV = ImageIO.read(new File("HULK_4a_inv.png"));
        hulkImage4bINV = ImageIO.read(new File("HULK_4b_inv.png"));

    }

    public void move() {
        if (UP == false) {
            x += dx;
        } else if (UP == true && x < (WINDOW_WIDTH - HERO_WIDTH) && x > 0) {
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

    public Image getImage0() {
        return hulkImage0;
    }

    public Image getImage0INV() {
        return hulkImage0INV;
    }

    public Image getImage1() {
        return hulkImage1;
    }

    public Image getImage1INV() {
        return hulkImage1INV;
    }

    public Image getImage2a() {
        return hulkImage2a;
    }

    public Image getImage2b() {
        return hulkImage2b;
    }

    public Image getImage2aINV() {
        return hulkImage2aINV;
    }

    public Image getImage2bINV() {
        return hulkImage2bINV;
    }

    public Image getImage3a() {
        return hulkImage3a;
    }

    public Image getImage3b() {
        return hulkImage3b;
    }

    public Image getImage3c() {
        return hulkImage3c;
    }

    public Image getImage4a() {
        return hulkImage4a;
    }

    public Image getImage4b() {
        return hulkImage4b;
    }

    public Image getImage3aINV() {
        return hulkImage3aINV;
    }

    public Image getImage3bINV() {
        return hulkImage3bINV;
    }

    public Image getImage3cINV() {
        return hulkImage3cINV;
    }

    public Image getImage4aINV() {
        return hulkImage4aINV;
    }

    public Image getImage4bINV() {
        return hulkImage4bINV;
    }

    public Image getImage() {
        return temp;
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

    public void setImage(Image hulk) {
        temp = hulk;

    }

    private boolean hitting() {
        if (getImage() == hulkImage1 || getImage() == hulkImage1INV || getImage() == hulkImage2a || getImage() == hulkImage2b || getImage() == hulkImage2aINV || getImage() == hulkImage2bINV) {
            return false;
        } else {
            return true;
        }
    }

    public void moveHulkUp() {
        if (UP == true && !hitting()) {
            
            
            setImage(getImage2a());
            this.hulkMotioncount += 10;
            if (this.hulkMotioncount % 50 == 0) {

                hulkMotioncount = 0;

                if (HulkFall <= 15) {
                    dy = -20;
                    move();
                } else if (HulkFall >= 16 && HulkFall < 32) {
                    dy = 20;
                    move();
                }

                if (HulkFall >= 33) {
                    dy = 0;
                    move();
                }
                HulkFall++;
            }
        }

//        if (UP == true && RIGHT == true && (x + 20) <= (WINDOW_WIDTH - HERO_WIDTH)) {
//            setImage(getImage2a());
//
//            if ((y > (WINDOW_HEIGHT / 2) - 150)) {
//                this.hulkMotioncount += 10;
//                if (this.hulkMotioncount % 10 == 0) {
//
//                    hulkMotioncount = 0;
//
//                    if (HulkFall <= 15) {
//                        dy = -20;
//                        dx = 20;
//                        move();
//                    } else if (HulkFall >= 16 && HulkFall < 32) {
//                        dy = 20;
//                        dx = 20;
//                        move();
//                    }
//
//                    if (HulkFall >= 33) {
//                        dy = 0;
//                        move();
//                    }
//                    HulkFall++;
//                }
//            }
//        }
//
//        if (UP == true && LEFT == true && ((x - 10) >= (0))) {
//            setImage(getImage2aINV());
//            if ((y > (WINDOW_HEIGHT / 2) - 150)) {
//                this.hulkMotioncount += 10;
//                if (this.hulkMotioncount % 10 == 0) {
//
//                    hulkMotioncount = 0;
//
//                    if (HulkFall <= 15) {
//                        dy = -20;
//                        dx = -20;
//                        move();
//                    } else if (HulkFall >= 16 && HulkFall <= 32) {
//                        dy = 20;
//                        dx = -20;
//                        if (HulkFall == 32) {
//                            dy = 15;
//                        }
//                        move();
//                    }
//
//                    if (HulkFall >= 33) {
//                        dy = 0;
//                        dx = 0;
//                        move();
//                    }
//                    HulkFall++;
//                }
//                HulkFall = 0;
//
//            }
//
//        }
    }

    public void moveHulkRight() {
        if (RIGHT == true && (!hitting())) {
            if ((x + 10) >= (WINDOW_WIDTH - HERO_WIDTH)) {

                if (this.hulkMotioncount == 0) {
                    dx = 0;
                    if (this.hulkstate == 0) {
                        this.hulkstate = 1;
                    } else if (this.hulkstate == 1) {
                        this.hulkstate = 2;
                    } else if (this.hulkstate == 2) {
                        this.hulkstate = 1;
                    }
                }

                switch (this.hulkstate) {
                    case 0:
                        setImage(hulkImage1);
                        break;
                    case 1:
                        setImage(hulkImage2a);
                        break;
                    case 2:
                        setImage(hulkImage2b);
                        break;
                }

                this.hulkMotioncount += 10;
                if (this.hulkMotioncount % 60 == 0) {
                    hulkMotioncount = 0;

                }

            } else {
                if (this.hulkMotioncount == 0) {
                    dx = 4;
                    if (this.hulkstate == 0) {
                        this.hulkstate = 1;
                    } else if (this.hulkstate == 1) {
                        this.hulkstate = 2;
                    } else if (this.hulkstate == 2) {
                        this.hulkstate = 1;
                    }
                }

                switch (this.hulkstate) {
                    case 0:
                        setImage(hulkImage1);
                        break;
                    case 1:
                        setImage(hulkImage2a);
                        break;
                    case 2:
                        setImage(hulkImage2b);
                        break;
                }

                this.hulkMotioncount += 10;
                if (this.hulkMotioncount % 170 == 0) {
                    hulkMotioncount = 0;
                }
            }
            move();
        }
    }

    public void moveHulkLeft() {

        if (LEFT == true && (!hitting())) {
            if ((x - 10) <= (0)) {

                if (this.hulkMotioncount == 0) {
                    dx = 0;
                    if (this.hulkstate == 0) {
                        this.hulkstate = 1;
                    } else if (this.hulkstate == 1) {
                        this.hulkstate = 2;
                    } else if (this.hulkstate == 2) {
                        this.hulkstate = 1;
                    }
                }

                switch (this.hulkstate) {
                    case 0:
                        setImage(hulkImage1);
                        break;
                    case 1:
                        setImage(hulkImage2aINV);
                        break;
                    case 2:
                        setImage(hulkImage2bINV);
                        break;
                }

                this.hulkMotioncount += 10;
                if (this.hulkMotioncount % 170 == 0) {
                    hulkMotioncount = 0;

                }

            } else {
                if (this.hulkMotioncount == 0) {
                    dx = -4;
                    if (this.hulkstate == 0) {
                        this.hulkstate = 1;
                    } else if (this.hulkstate == 1) {
                        this.hulkstate = 2;
                    } else if (this.hulkstate == 2) {
                        this.hulkstate = 1;
                    }
                }

                switch (this.hulkstate) {
                    case 0:
                        setImage(hulkImage1);

                        break;
                    case 1:
                        setImage(hulkImage2aINV);
                        break;
                    case 2:
                        setImage(hulkImage2bINV);
                        break;
                }

                this.hulkMotioncount += 10;
                if (this.hulkMotioncount % 170 == 0) {
                    hulkMotioncount = 0;
                }
            }
            move();
        }
    }

    public void hit1() {
        timer = new Timer();
        RIGHT = false;
        LEFT = false;
        if (getImage() == hulkImage1 || getImage() == hulkImage2a || getImage() == hulkImage2b) {
            setImage(hulkImage3a);
            timer.schedule(new to3b(), 500);
            timer.schedule(new to3c(), 1000);
            timer.schedule(new to1(), 1500);
        } else if (getImage() == hulkImage1INV || getImage() == hulkImage2aINV || getImage() == hulkImage2bINV) {
            timer = new Timer();
            setImage(hulkImage3aINV);
            timer.schedule(new to3bI(), 500);
            timer.schedule(new to3cI(), 1000);
            timer.schedule(new to1I(), 1500);
        }
    }

    public void hit2() throws FileNotFoundException, IOException {
        timer = new Timer();
        RIGHT = false;
        LEFT = false;
        if (getImage() == hulkImage1 || getImage() == hulkImage2a || getImage() == hulkImage2b) {
            setImage(hulkImage4a);
            InputStream in = new FileInputStream("AngryVoice.wav");
            AudioStream audioStream2 = new AudioStream(in);
            AudioPlayer.player.start(audioStream2);
            timer.schedule(new to4b(), 500);
            timer.schedule(new to1(), 1000);
        } else if (getImage() == hulkImage1INV || getImage() == hulkImage2aINV || getImage() == hulkImage2bINV) {
            setImage(hulkImage4aINV);
            timer.schedule(new to4bI(), 500);
            timer.schedule(new to1I(), 1000);
        }
    }

    public void keyPressed(KeyEvent e) throws IOException, InterruptedException {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP && TIME_ENDS == false) {
            UP = true;

        }
        if (TIME_ENDS == false) {
            if (key == KeyEvent.VK_LEFT) {

                LEFT = true;
            }

            //--------------------------------------------------------------
            if (key == KeyEvent.VK_RIGHT) {

                RIGHT = true;
            }
        }

    }

    public void keyReleased(KeyEvent e) throws IOException {

        int key = e.getKeyCode();
        this.hulkstate = 0;
        this.hulkMotioncount = 0;

        if (key == KeyEvent.VK_UP && TIME_ENDS == false) {
            UP = false;
            HulkFall = 0;
            y = (4 * WINDOW_HEIGHT) / 9;
            RIGHT = false;
            LEFT = false;
            if (getImage() == hulkImage2aINV) {
                setImage(hulkImage1INV);
            } else {
                setImage(hulkImage1);
            }
        } else if (key == KeyEvent.VK_LEFT && TIME_ENDS == false) {

            LEFT = false;
            dx = 0;
            if (!hitting()) {
                setImage(hulkImage1INV);
            }
        } else if (key == KeyEvent.VK_RIGHT && TIME_ENDS == false) {

            RIGHT = false;
            dx = 0;
            if (!hitting()) {
                setImage(hulkImage1);
            }

        }
    }

    public void keyTyped(KeyEvent e) throws IOException, InterruptedException {
        timer = new Timer();
        if (TIME_ENDS == false) {
            if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                hit1();
            } else if (e.getKeyChar() == 'n' || e.getKeyChar() == 'N') {
                hit2();
            }
        }
    }

    class to3b extends TimerTask {

        public void run() {
            setImage(hulkImage3b);
        }
    }

    class to3bI extends TimerTask {

        public void run() {
            setImage(hulkImage3bINV);
        }
    }

    class to3c extends TimerTask {

        public void run() {
            setImage(hulkImage3c);
        }
    }

    class to3cI extends TimerTask {

        public void run() {
            setImage(hulkImage3cINV);
        }
    }

    class to1 extends TimerTask {

        public void run() {
            setImage(hulkImage1);
        }
    }

    class to1I extends TimerTask {

        public void run() {
            setImage(hulkImage1INV);
        }
    }

    class to4b extends TimerTask {

        public void run() {
            setImage(hulkImage4b);
        }
    }

    class to4bI extends TimerTask {

        public void run() {
            setImage(hulkImage4bINV);
        }
    }
}

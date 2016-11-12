package programmingproject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlackWidowHealth {
private Image []bar = new Image[21];
    
    private Image temp;
    
    public BlackWidowHealth() throws IOException{
        
        bar[0] = ImageIO.read(new File("Hb00.png"));
        bar[1] = ImageIO.read(new File("Hb01.png"));
        bar[2] = ImageIO.read(new File("Hb02.png"));
        bar[3] = ImageIO.read(new File("Hb03.png"));
        bar[4] = ImageIO.read(new File("Hb04.png"));
        bar[5] = ImageIO.read(new File("Hb05.png"));
        bar[6] = ImageIO.read(new File("Hb06.png"));
        bar[7] = ImageIO.read(new File("Hb07.png"));
        bar[8] = ImageIO.read(new File("Hb08.png"));
        bar[9] = ImageIO.read(new File("Hb09.png"));
        bar[10] = ImageIO.read(new File("Hb10.png"));
        bar[11] = ImageIO.read(new File("Hb11.png"));
        bar[12] = ImageIO.read(new File("Hb12.png"));
        bar[13] = ImageIO.read(new File("Hb13.png"));
        bar[14] = ImageIO.read(new File("Hb14.png"));
        bar[15] = ImageIO.read(new File("Hb15.png"));
        bar[16] = ImageIO.read(new File("Hb16.png"));
        bar[17] = ImageIO.read(new File("Hb17.png"));
        bar[18] = ImageIO.read(new File("Hb18.png"));
        bar[19] = ImageIO.read(new File("Hb19.png"));
        bar[19] = ImageIO.read(new File("Hb19.png"));
        bar[20] = ImageIO.read(new File("Hb20.png"));
        
        temp=bar[20];
    }

  
    public Image getBar( int i){
        return bar[i];
    }

    public Image getFinalBar() {
        return temp;
    }
    
    
 }

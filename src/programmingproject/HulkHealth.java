package programmingproject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class HulkHealth {

    
  private javax.swing.Timer timer;
    
    private Image []bar = new Image[21];
    
    private Image temp;
    
    public HulkHealth() throws IOException{
        
        bar[0] = ImageIO.read(new File("H00.png"));
        bar[1] = ImageIO.read(new File("H01.png"));
        bar[2] = ImageIO.read(new File("H02.png"));
        bar[3] = ImageIO.read(new File("H03.png"));
        bar[4] = ImageIO.read(new File("H04.png"));
        bar[5] = ImageIO.read(new File("H05.png"));
        bar[6] = ImageIO.read(new File("H06.png"));
        bar[7] = ImageIO.read(new File("H07.png"));
        bar[8] = ImageIO.read(new File("H08.png"));
        bar[9] = ImageIO.read(new File("H09.png"));
        bar[10] = ImageIO.read(new File("H10.png"));
        bar[11] = ImageIO.read(new File("H11.png"));
        bar[12] = ImageIO.read(new File("H12.png"));
        bar[13] = ImageIO.read(new File("H13.png"));
        bar[14] = ImageIO.read(new File("H14.png"));
        bar[15] = ImageIO.read(new File("H15.png"));
        bar[16] = ImageIO.read(new File("H16.png"));
        bar[17] = ImageIO.read(new File("H17.png"));
        bar[18] = ImageIO.read(new File("H18.png"));
        bar[19] = ImageIO.read(new File("H19.png"));
        bar[20] = ImageIO.read(new File("H20.png"));
        
        temp=bar[20];
        
    }

  
    public Image getBar( int i){
        return bar[i];
    }
    
     public Image getFinalBar() {
        return temp;
    }
}

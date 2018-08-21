package programmingproject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class HulkHealth {
    
    private Image []bar = new Image[21];
    
    private Image temp;
    
    public HulkHealth() throws IOException{
        
        bar[0] = ImageIO.read(new File("src/resources/H00.png"));
        bar[1] = ImageIO.read(new File("src/resources/H01.png"));
        bar[2] = ImageIO.read(new File("src/resources/H02.png"));
        bar[3] = ImageIO.read(new File("src/resources/H03.png"));
        bar[4] = ImageIO.read(new File("src/resources/H04.png"));
        bar[5] = ImageIO.read(new File("src/resources/H05.png"));
        bar[6] = ImageIO.read(new File("src/resources/H06.png"));
        bar[7] = ImageIO.read(new File("src/resources/H07.png"));
        bar[8] = ImageIO.read(new File("src/resources/H08.png"));
        bar[9] = ImageIO.read(new File("src/resources/H09.png"));
        bar[10] = ImageIO.read(new File("src/resources/H10.png"));
        bar[11] = ImageIO.read(new File("src/resources/H11.png"));
        bar[12] = ImageIO.read(new File("src/resources/H12.png"));
        bar[13] = ImageIO.read(new File("src/resources/H13.png"));
        bar[14] = ImageIO.read(new File("src/resources/H14.png"));
        bar[15] = ImageIO.read(new File("src/resources/H15.png"));
        bar[16] = ImageIO.read(new File("src/resources/H16.png"));
        bar[17] = ImageIO.read(new File("src/resources/H17.png"));
        bar[18] = ImageIO.read(new File("src/resources/H18.png"));
        bar[19] = ImageIO.read(new File("src/resources/H19.png"));
        bar[20] = ImageIO.read(new File("src/resources/H20.png"));
        
        temp=bar[20];
        
    }

  
    public Image getBar( int i){
        return bar[i];
    }
    
     public Image getFinalBar() {
        return temp;
    }
}

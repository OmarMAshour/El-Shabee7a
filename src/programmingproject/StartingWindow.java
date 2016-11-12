package programmingproject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Arrays;
import static programmingproject.ProgrammingProject.*;


public class StartingWindow extends JFrame{

   public StartingWindow () throws IOException{
        DisplayMode dm = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setContentPane(new JLabel(new ImageIcon("Logo.gif")));

        this.getContentPane().setBackground(Color.BLACK);
        Screen s = new Screen();
        
        try{
        s.setFullScreen(dm, this);
        try{
            Thread.sleep(4300);
        }
        
        catch(Exception e){
        
            System.out.println("Exception in setting StartingWindow to full screen mode");
            this.setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
        }
        }
        finally{
            this.setVisible(false);
           // s.restoreScreen();
            MainWindow mw = new MainWindow();
        }
        
        this.setVisible(true);
    }
   
//   @Override
//    public void paint (Graphics g){
//        super.paint(g);
//         try{
//        Image img = ImageIO.read(new File("s2.gif"));
//        g.drawImage(img, 0, 0,getWidth(),getHeight(), null);
//
//         }catch(Exception e ){}
//        //g.drawString("ya RAB", 200, 200);
//    }
}

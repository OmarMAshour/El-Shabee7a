package programmingproject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import static programmingproject.ProgrammingProject.*;

public class SingleBoard extends JFrame{
    
    private SinglePanel pnl;
    
    public SingleBoard() throws IOException{
        
         DisplayMode dm = new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         Container c = this.getContentPane();
         c.setLayout(null);
         
         pnl = new SinglePanel();
         pnl.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
         
         c.add(pnl);
         
         
         
         Screen s = new Screen();
        
        try{
        s.setFullScreen(dm, this);
        
        }
        catch(Exception e){
        
            System.out.println("Exception in setting MainWindow to full screen mode");
            this.setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));

        }
         
         this.setVisible(true);
         
         
         
    }
    
   

}

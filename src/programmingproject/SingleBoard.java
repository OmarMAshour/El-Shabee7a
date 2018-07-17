package programmingproject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import static programmingproject.ProgrammingProject.*;

public class SingleBoard extends JPanel{
    
    private SinglePanel pnl;
    
    public SingleBoard() throws IOException{
        
         
         setLayout(null);
         
         pnl = new SinglePanel();
         pnl.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
         
         add(pnl);
         
         
    }
    
   

}

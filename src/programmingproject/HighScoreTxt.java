package programmingproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static programmingproject.ProgrammingProject.*;

public class HighScoreTxt {

    public static void Load(){
           try{
            
           BufferedReader br = null;

           br = new BufferedReader(new FileReader("HighScores.txt"));		

           //One way of reading the file
	   System.out.println("Reading the log.txt file using readLine() method:");
	   
           for(int i=0;i<HIGHSCORES.length;i++)
           {
               String x = br.readLine();
               
               if(x!=null){
               HIGHSCORES[i]=Integer.parseInt(x);
               }
               if(HIGHSCORES[i]!=0){
               System.out.println(HIGHSCORES[i]);
               }
           }
           
          
           br.close();
           }
           
           catch(IOException e){
                   System.out.println("IOException in loading HighScores.txt try/catch 1");
                   }
           catch (NullPointerException ex)
           {
                    System.out.println("NullPointerException in loading HighScores.txt try/catch 1");

           }

    	  System.out.println("****************************************************************");

    }

  public static void Save(){
        
          try{
    	
        //Specify the file name and path here
    	File file =new File("HighScores.txt");

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
    	BufferedWriter bw = new BufferedWriter(fw);
        //PrintWriter writer for more higher performance
        PrintWriter pw = new PrintWriter(bw);
    	
        
        
    	
        //This will add a new line to the file content
        /* Below three statements would add three 
         * mentioned Strings to the file in new lines.
         */
          for(int i=0;i<HIGHSCORES.length;i++){
              if(HIGHSCORES[i]!=0){
              pw.println(HIGHSCORES[i]);
          }
          }
         
    	//Closing BufferedWriter Stream
         pw.close();
        //This will add a new line to the file content
    	  
	System.out.println("Data successfully appended in HighScores.txt file");

      }catch(Exception e){
         System.out.println("Exception occurred \" ERROR \"");
       }
        
    	  System.out.println("****************************************************************");
        
    }
    
    public static void clear(){
        try{
        FileWriter fwOb = new FileWriter("HighScores.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        }
        catch(Exception e){
            System.out.println("Error Clearing File HighScores.txt");
        }
            	  System.out.println("****************************************************************");

    }
}

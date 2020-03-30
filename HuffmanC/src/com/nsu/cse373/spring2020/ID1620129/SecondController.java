package com.nsu.cse373.spring2020.ID1620129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class SecondController extends Application{
	
	


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public static String  SelectedFile(File f) throws IOException { //Reads from selected file
		
		
		   BufferedReader reader = new BufferedReader(new FileReader(f));

	        String line;
	         String s ="";
	        while ((line = reader.readLine()) != null)
	        	s = s + line;
	           // System.out.println(line);


	           
	       //System.out.println(s);   
	        return s;
	        
	}
	
	public static void toStoreDecode(String S) throws IOException{
		
		
		   try {
			      FileWriter myWriter = new FileWriter("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\Decoded.txt");
			      myWriter.write(S);
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	}























package com.nsu.cse373.spring2020.ID1620129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class SecondController extends Application{
	
	


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public String  SelectedFile(File f) throws IOException { //Reads from selected file
		
		
		   BufferedReader reader = new BufferedReader(new FileReader(f));

	        String line;
	         String s ="";
	        while ((line = reader.readLine()) != null)
	        	s = s + line;
	           // System.out.println(line);


	           
	       //System.out.println(s);   
	        return s;
	        
	}
	}


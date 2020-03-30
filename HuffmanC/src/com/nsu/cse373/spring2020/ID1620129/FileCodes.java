package com.nsu.cse373.spring2020.ID1620129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;


class FileCodes {

	public static double MainFileSize;
	public static double EncodedFileSize;
	public static String  SelectedFile(File f) throws IOException { //Reads from selected file
		
		
		   BufferedReader reader = new BufferedReader(new FileReader(f));

	        String line;
	         String s ="";
	        while ((line = reader.readLine()) != null)
	        	s = s + line;
	           // System.out.println(line);

	        MainFileSize = f.length();
	        System.out.println("Size " + MainFileSize);
	           
	       //System.out.println(s);   
	        return s;
	        
	}
	
	public static void toStoreDecode(String S) throws IOException{
		
		
		   try {
			    
			      FileWriter myWriter = new FileWriter("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\Decoded.txt");
			      myWriter.write(S);
			      myWriter.close();
			      System.out.println("Successfully wrote to the file.");
	

			      Path filePath = Paths.get("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\Decoded.txt");
				  FileChannel fileChannel;
			      
			      fileChannel = FileChannel.open(filePath);		   
			      EncodedFileSize = fileChannel.size();

			      
			        System.out.println("Size " + EncodedFileSize);
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		
		
		
		
		
		
		
		
		
		
		
	}



}

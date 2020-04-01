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
	public static String location;
	public static String  SelectedFile(File f) throws IOException { //Reads from selected file
		
		
		   BufferedReader reader = new BufferedReader(new FileReader(f));

	        String line;
	         String s ="";
	        while ((line = reader.readLine()) != null)
	        	s = s + line;
	           // System.out.println(line);

	        MainFileSize = f.length();
	        reader.close();
	        System.out.println("Size " + MainFileSize);
	           
	       //System.out.println(s);   
	        return s;
	        
	}
	
	public static void toStoreEncode(String S) throws IOException{
		
		
		   try {
			    
			      FileWriter myWriter = new FileWriter("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\Encoded.txt");
			      myWriter.write(S);
			      myWriter.close();
			      System.out.println("Successfully wrote to the Encoded file.");
	

			      Path filePath = Paths.get("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\Encoded.txt");
				  FileChannel fileChannel;
			      
			      fileChannel = FileChannel.open(filePath);		   
			      EncodedFileSize = fileChannel.size();

			      
			        System.out.println("Size " + EncodedFileSize);
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public static void toStoreDecodedFile(String S) throws IOException{
		
		
		   try {
			    
			       location = "src\\com\\nsu\\cse373\\spring2020\\ID1620129\\Decoded.txt";
			      FileWriter myWriter = new FileWriter(location);
			      myWriter.write(S);
			      myWriter.close();
			      System.out.println("Successfully wrote to the Decoded file.");
			      System.out.println(location);
	
			    } catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
	
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}

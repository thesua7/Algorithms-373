package com.nsu.cse373.spring2020.ID1620129;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileCodes {


	private String NoOfNode; 
	private String NoOfEdge;

	
	public  void readFromFile(String arr[]) throws IOException {
		
   
	   	  File FileDes = new File("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\data.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(FileDes)); 
		  
		  String st; 
		  
		  int i =0;
		  while ((st = br.readLine()) != null) { 
		 
     	  arr[i] = st;
		  i++;

		  }
		
		  String s = arr[0].trim();
		  String[] words = s.split(" ");
		 
		  NoOfNode = words[0];
		  NoOfEdge = words[words.length - 1];
		  
		  

	}
	
	public String getNoOfNode() {
		return NoOfNode;
	}
	
	
	
	public String getNoOfEdge() {
		return NoOfEdge;
	}
	
	

	
	
	
	
	
}

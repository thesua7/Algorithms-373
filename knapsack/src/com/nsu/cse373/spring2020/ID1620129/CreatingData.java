package com.nsu.cse373.spring2020.ID1620129;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class CreatingData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        int NumberOfJar =(int) getRandomIntegerBetweenRange(200,1000);
        
        float knapsacksize = (float) getRandomIntegerBetweenRange(40,80);
        
        writingfirstLine(NumberOfJar,knapsacksize);
        
        
        for(int i=0;i<NumberOfJar;i++) {
        	String jarName = "JAR_"+(i+1);
        	String jarPrice = String.valueOf((int)getRandomIntegerBetweenRange(20,120));
        	String jarSize= String.valueOf((float)getRandomIntegerBetweenRange(1.3,51.6));
        	fileWriteForKnapsack("data.txt",jarName,jarPrice,jarSize);
        	
        }

		
		
	}	
	
	
	

public static double getRandomIntegerBetweenRange(double min, double max){
	double x = (double)(Math.random()*((max-min)+1))+min;
    return x;
}


public static void writingfirstLine(int njars,float ksize) {
	
	
	 try {
	    	File FileDes = new File("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\data.txt");


	        FileWriter writer = new FileWriter(FileDes, true);
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);
	        
		

	        bufferedWriter.write(String.valueOf(njars));
	        bufferedWriter.write(" ");
	        bufferedWriter.write(String.valueOf(ksize));
	        bufferedWriter.newLine();
	        
	        bufferedWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	
}



public static void fileWriteForKnapsack(String filename,String Jarname,String Jarprice,String Jarsize) {
	
    try {
    	File xmlFile = new File("src\\com\\nsu\\cse373\\spring2020\\ID1620129\\"+filename);


        FileWriter writer = new FileWriter(xmlFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        
	

        bufferedWriter.write(Jarname);
        bufferedWriter.write(" ");
        bufferedWriter.write(Jarprice);
        bufferedWriter.write(" ");
        bufferedWriter.write(Jarsize);
        bufferedWriter.newLine();
        
        bufferedWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
	
	
}







}

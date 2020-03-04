package com.nsu.cse373.spring2020.ID1620129;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public abstract class main implements Comparator<String>{

	public static void main(String[] args) throws IOException {
		
		
		
		
		readFile();
		
	}
	
	
	public static void readFile() throws IOException {
		
		
		String arr[] = new String[50000];
		
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
		  String firstWord = words[0];
		  String lastWord = words[words.length - 1];
		  int numberOfjars = Integer.valueOf(firstWord)+1;
		  float knapsackSize = Float.valueOf(lastWord);

		
		  List<String> nameList = Arrays.asList(arr);
		  Collections.sort(nameList.subList(1, numberOfjars), new Comparator<String>() {

		      @Override
		      public int compare(String arg0, String arg1) { //Custom comparator
		          String first0 = arg0.split(" ")[1];
		          String first1 = arg1.split(" ")[1];
		          int f = Integer.valueOf(first0);
		          int f1 = Integer.valueOf(first1);
		          int v = Integer.compare(f, f1);       //Comparing by 2nd word(Price)
		          return v;
		      }
		  });

		  
	
		  
  
		  System.out.println("Printing the sorted, In reverse order: ");
		  for(int k=numberOfjars-1;k>=1;k--) {
			  System.out.println(arr[k]);
		  }

		     System.out.println();
		     System.out.println();
		  
	     float sum=0;
		 int l = numberOfjars-1;
		 int count=0;
		 String ItemsTaken[] = new String[10000];
		 
		 int iTaken = 0;
		 
	
		  while(sum<=knapsackSize) {  //Pushing Jars in to the knapsack Jar
			  
			  String temp = arr[l].trim();
			  String[] wordsTemp = temp.split(" ");
			  String jsizeTemp = wordsTemp[2];
			  float jsizeFloatTemp = Float.valueOf(jsizeTemp); //Getting the JarSize
			  
			  	
			  if(sum>jsizeFloatTemp) {
				  
				  float need = knapsackSize-sum;
				  
				  if(need<=jsizeFloatTemp) {
					  sum = sum+need;
					  ItemsTaken[iTaken] = temp;
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(need));

					  iTaken++;

					  
					 
				  }
				  
				  else {
					  sum = sum+jsizeFloatTemp;
					  ItemsTaken[iTaken] = temp;
					  ItemsTaken[iTaken] =  ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(jsizeFloatTemp));

					  iTaken++;

				  }
				  
				  
				  System.out.print(wordsTemp[0]);	
				  System.out.println("  "+jsizeFloatTemp+" 1st "+sum+" "+count);
				  count++;
		
			  }
			  
			  if(sum<=jsizeFloatTemp) {	
				  
				  float need1 = knapsackSize-sum;
				  
				  if(jsizeFloatTemp<=need1) {
					  sum = sum + jsizeFloatTemp;
					  
					  ItemsTaken[iTaken] = temp;
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(jsizeFloatTemp));

					  iTaken++;

				  }

				  else {
					  sum = sum+need1;
					  
					  ItemsTaken[iTaken] = temp;
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(need1));

					  iTaken++;

				  }
		  
				  System.out.print(wordsTemp[0]);	
				  System.out.println("  "+jsizeFloatTemp+" 2nd "+sum+" "+count);
				  
				  count++;
				  
		
			  }
			  if(sum==knapsackSize) {
				  break;
			  }
			
			  l--;
			  
		  }
		  
		  System.out.println("==================");
		  System.out.println("==================");
		  System.out.println("==================");
		  
		  
		  
		  
		  int knapsackPriceTotal = 0;
		  for(int o=0;o<count;o++) {
			  
			  String temp = ItemsTaken[o].trim();
			  String[] wordsTemp = temp.split(" ");
			  String priceS = wordsTemp[1];
			  int price = Integer.valueOf(priceS);
			  knapsackPriceTotal = knapsackPriceTotal + price;
			  }
		  
		  System.out.println("Total knapsack Value: "+knapsackPriceTotal);
		  System.out.println("Total Weight of the knapsack: "+sum+"\n");

		  System.out.println("Jars that taken with the price and weight: ");
		  for(int m=0;m<count;m++) {
             System.out.println(ItemsTaken[m]);
		  }
		  
		  
	

		
		
	}


	
	

}



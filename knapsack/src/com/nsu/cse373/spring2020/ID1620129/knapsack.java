package com.nsu.cse373.spring2020.ID1620129;

import java.util.List;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public abstract class knapsack implements Comparator<String>{

	public static void main(String[] args) throws IOException {
		
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
		          String fprice0 = arg0.split(" ")[1];
		          String fprice1 = arg1.split(" ")[1];
		          String fsize0 = arg0.split(" ")[2];
		          String fsize1 = arg1.split(" ")[2]; 
		          
		          
		          
		          
		          int f = Integer.valueOf(fprice0);
		          int f1 = Integer.valueOf(fprice1);
                  float size1 = Float.parseFloat(fsize0);
                  float size2 = Float.parseFloat(fsize1);
                  
                  Float unit = f/size1;
                  Float unit1 = f1/size2;
                  int m = Float.compare(unit, unit1);
               
		
		          return m;
		      }
		  });

		  
	
		  
  

		  
	     float sum=0;
		 int l = numberOfjars-1;
		 int count=0;
		 String ItemsTaken[] = new String[10000];
		 
		 int iTaken = 0;
		 
	
		  while(sum<=knapsackSize) {  //Pushing Jars in to the knapsack Jar
			  
			  String temp = arr[l].trim();
			  String[] wordsTemp = temp.split(" ");
			  String jsizeTemp = wordsTemp[2];
			  String jpriceTemp = wordsTemp[1];
			  float jsizeFloatTemp = Float.valueOf(jsizeTemp); //Getting the JarSize
			  int jprice = Integer.valueOf(jpriceTemp); //Getting the JarPrice
			  
			  	
			  if(sum>jsizeFloatTemp) {
				  
				  float need = knapsackSize-sum;
				  
				  if(need<=jsizeFloatTemp) {
					  sum = sum+need;
					  ItemsTaken[iTaken] = temp;
					  Float unitP1 = jprice/jsizeFloatTemp; 
					  Float takenPrice = need*unitP1;
					
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jpriceTemp, Float.toString(takenPrice));
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(need));

					  iTaken++;

					  
					 
				  }
				  
				  else {
					  sum = sum+jsizeFloatTemp;
					  ItemsTaken[iTaken] = temp;
					  ItemsTaken[iTaken] =  ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(jsizeFloatTemp));

					  iTaken++;

				  }
				  
				  
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
					  Float unitP = jprice/jsizeFloatTemp;
					  Float takenPrice = need1*unitP;
				
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jpriceTemp, Float.toString(takenPrice));
					  ItemsTaken[iTaken] = ItemsTaken[iTaken].replace(jsizeTemp, Float.toString(need1));

					  iTaken++;

				  }
		  
	
				  
				  count++;
				  
		
			  }
			  if(sum==knapsackSize) {
				  break;
			  }
			
			  l--;
			  
		  }

		  
		  
		  


		  System.out.println("Jars that taken with the price and weight: ");
		  for(int m=0;m<count;m++) {
             System.out.println(ItemsTaken[m]);
		  }
		  
		  System.out.println("==================");
		  
		  float knapsackPriceTotal = 0;
		  for(int o=0;o<count;o++) {
			  
			  String temp = ItemsTaken[o].trim();
			  String[] wordsTemp = temp.split(" ");
			  String priceS = wordsTemp[1];
			  Float price = Float.valueOf(priceS);
			  knapsackPriceTotal = knapsackPriceTotal + price;
			  }
		  
		  System.out.println("Total knapsack Value: "+knapsackPriceTotal);
		  System.out.println("Total Weight of the knapsack: "+sum+"\n");
		  
	

		
	}
	

	

}



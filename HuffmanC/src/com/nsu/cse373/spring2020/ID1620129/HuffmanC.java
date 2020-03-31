package com.nsu.cse373.spring2020.ID1620129;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class HuffmanC {

	private final static int R = 256;
	public static HuffmanNode root;
	public static char [] characters;
	public static int [] frequency;
	public static void Genarate(String line){
		
	 characters = line.toCharArray();
		
		
          frequency = new int[R];
		
		for(int i = 0 ; i < characters.length; i++){
			frequency[characters[i]]++;
			
		
			
		}
		
	root = buildTree(frequency);
		
	    String[] dictionaryKeys = new String[R];
		createKeys(dictionaryKeys, root, "");
		
	
		
		HomeController.mArray = dictionaryKeys; //Passing to global array after encoding

	}
	
	
	
	
	
	
	
	public static HuffmanNode buildTree(int [] frequency){
		//Create priority queue for nodes
	    Queue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
		
		for(char i = 0; i < frequency.length; i++){
			if(frequency[i] > 0){
				//create leaf nodes, and add it to the priority queue
				pq.add(new HuffmanNode(i, frequency[i], null, null));
			}
		}
		
		while(pq.size() > 1){
			HuffmanNode right = pq.remove();
			HuffmanNode left = pq.remove();
			HuffmanNode parent = new HuffmanNode('\0', left.getFrequency() + right.getFrequency(), left, right);
			
			pq.add(parent);
		}
		
		return pq.poll();
	}
	
	public static void createKeys(String [] keys, HuffmanNode current, String key){
	

		if(current.isLeaf()){
			keys[current.getSymbol()] = key;

			
		}else{
			createKeys(keys, current.left, key + "0");
			createKeys(keys, current.right, key + "1");
		}
	}
	
	
	public static String decode(String input) {
		
		String result = "";
		HuffmanNode n = root;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '0') { // 0:left; 1:right
				n = n.left;
			} else {
				n = n.right;
			}
			if (n.left == null) // n is a leaf == n.right ==null;
			{
				result = result + n.symbol;
				n = root;
			
			}
		}
		return result;
		
		

	}
	
	  public static String unique(String s) //Removes String duplicates character
	                                        //Used from: https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
	    { 
	        String str = new String(); 
	        int len = s.length(); 
	          
	        // loop to traverse the string and 
	        // check for repeating chars using 
	        // IndexOf() method in Java 
	        for (int i = 0; i < len; i++)  
	        { 
	            // character at i'th index of s 
	            char c = s.charAt(i); 
	              
	            // if c is present in str, it returns 
	            // the index of c, else it returns -1 
	            if (str.indexOf(c) < 0) 
	            { 
	                // adding c to str if -1 is returned 
	                str += c; 
	            } 
	        } 
	          
	        return str; 
	    } 
	
	
	
	
	
}

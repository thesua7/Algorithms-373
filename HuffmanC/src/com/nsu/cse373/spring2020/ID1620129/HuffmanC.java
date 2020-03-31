package com.nsu.cse373.spring2020.ID1620129;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


class HuffmanC {

	private final static int R = 256;
	public static HuffmanNode root;
	private static char [] characters;
	public static void Genarate(String line){
		
	 characters = line.toCharArray();
		
		
		int [] frequency = new int[R];
		
		for(int i = 0 ; i < characters.length; i++){
			frequency[characters[i]]++;
			System.out.println(characters[i]);
		
			
		}
		
		
		

	root = buildTree(frequency);
		
	    String[] dictionaryKeys = new String[R];
		createKeys(dictionaryKeys, root, "");
		
	
		
		HomeController.mArray = dictionaryKeys; //Passing to global array after encoding

	}
	
	
	
	
	
	
	
	public static HuffmanNode buildTree(int [] frequency){
		//Create priority queue for nodes
	    Queue<HuffmanNode> pq = new LinkedList<HuffmanNode>();
		
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
	
		String temp="";
		if(current.isLeaf()){
			//keys[current.getSymbol()] = key;
			for(int i=0;i<current.getFrequency();i++) {
				temp=key+temp;
			}
			keys[current.getSymbol()] = temp;
	        
			
			
			
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
	
	
	
	
	
}

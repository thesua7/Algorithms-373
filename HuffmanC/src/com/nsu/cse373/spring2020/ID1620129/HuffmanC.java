package com.nsu.cse373.spring2020.ID1620129;

import java.util.PriorityQueue;


class HuffmanC {

	private final static int R = 256;
	
	public static void Genarate(String line){
		
		char [] characters = line.toCharArray();
		
		
		int [] frequency = new int[R];
		
		for(int i = 0 ; i < characters.length; i++){
			frequency[characters[i]]++;
		}
		
		HuffmanNode root = buildTree(frequency);
		
	    String[] dictionaryKeys = new String[R];
		createKeys(dictionaryKeys, root, "");
		
	
		
		HomeController.mArray = dictionaryKeys; //Passing to global array after encoding

	}
	
	
	
	
	
	
	
	public static HuffmanNode buildTree(int [] frequency){
		//Create priority queue for nodes
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
		
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
	
	
	
	
	
	
}
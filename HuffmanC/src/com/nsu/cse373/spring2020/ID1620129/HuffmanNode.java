package com.nsu.cse373.spring2020.ID1620129;

class HuffmanNode implements Comparable<HuffmanNode> {
	//represents the total number of characters in the ASCII alphabet
	private final static int R = 256;
	int frequency;
	HuffmanNode left;
	HuffmanNode right;
	char symbol;
	
	public HuffmanNode(char symbol, int frequency, HuffmanNode left, HuffmanNode right){
		this.symbol = symbol;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeaf(){
		if(left == null && right == null){
			return true;
		}
		return false;
	}
	
	public int compareTo(HuffmanNode other){
		return this.frequency - other.frequency;
	}
	
	public char getSymbol(){
		return symbol;
	}
	
	public int getFrequency(){
		return frequency;
	}
	
	
	
}

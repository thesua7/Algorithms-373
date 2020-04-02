package com.nsu.cse373.spring2020.ID1620129;

import java.util.*;


class HuffmanC {


	public static HuffmanNode root;
    public static Map<Character,String> MAINMAP;
	
	public static String Encoding(String line){
		

		
		  root = buildTree(getCharFreq(line));
	
		  Map<Character, String> charCode = Genarate(root,getCharFreq(line).keySet());
		  String encodedString = encodeText(charCode, line);
		  
		  return encodedString;
		  
	}
	
	
	
	 public static HuffmanNode buildTree(Map<Character, Integer> map) {
	        Queue<HuffmanNode> pq = createNodeQueue(map);

	        while (pq.size() > 1) {
	          
	            HuffmanNode right = pq.remove();
	            HuffmanNode left = pq.remove();
	            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
	            pq.add(parent);
	        }

	        return pq.remove();
	    }
	 
	 
	 
	 public static Queue<HuffmanNode> createNodeQueue(Map<Character, Integer> map) {
	        Queue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(20,new HuffmanComprator()); //initial capacity=11 and a StudentComparator instance
	                                                                  //https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/

	        for (Map.Entry<Character, Integer> m : map.entrySet()) {

	            pq.add(new HuffmanNode(m.getKey(), m.getValue(), null, null));
	        }

	        return pq;

	    }
	 
	 
	  public static Map<Character, Integer> getCharFreq(String line)
	    {
	        Map<Character, Integer> charFreq = charecterFrequency(line);
	        return charFreq;
	    }
	
	  
	  
	  
	   public static Map<Character, Integer> charecterFrequency(String line) {

	        Map<Character, Integer> map = new HashMap<Character, Integer>();

	        for (int i = 0; i < line.length(); i++) {
	            char ch = line.charAt(i);
	            if (!map.containsKey(ch))
	                map.put(ch, 1);
	            else {
	                int val = map.get(ch);
	                map.put(ch, ++val);
	            }
	        }

	        return map;

	    }
	
	
	   
	   
	   
	   
	    public static Map<Character, String> Genarate(HuffmanNode node,Set<Character> chars) {
	        final Map<Character, String> map = new HashMap<Character, String>();
	        createKeys(node, map, "");
	        MAINMAP = map;
	        return map;
	        

	    } 
	   
	   
	   
	   
	   
	   public static void createKeys(HuffmanNode H, Map<Character, String> map, String s) {
	        if (H.left == null && H.right == null) //Creating keys based on Huffman Tree
	        {
	            map.put(H.symbol, s);
	            return;
	        }

	        createKeys(H.left,map,s +'0');
	        createKeys(H.right,map,s +'1');

	    }
	   
	   
	   
	   
	   static String encodeText(Map<Character, String> charCode, String line) {
	        final StringBuilder stringBuilder = new StringBuilder();

	        for (int i = 0; i < line.length(); i++) {
	            stringBuilder.append(charCode.get(line.charAt(i)));
	        }
	        return stringBuilder.toString();
	    }

	   
	   
	   
	   
	   
	    public static String Decoding(HuffmanNode root,String encodedMessage)
	    {

	        String decodedString = decodeText(root,encodedMessage);
	        return decodedString;
	    }
	    
	    public static String decodeText(HuffmanNode node, String EncodedLine) {

	        StringBuilder stringBuilder = new StringBuilder(); //Mapping to decode

	        BitSet bitSet = getBitSet(EncodedLine);

	        for (int i = 0; i < (bitSet.length() - 1); ) {
	            HuffmanNode temp = node;
	  
	            while (temp.left != null) {
	                if (!bitSet.get(i)) { 
	                    temp = temp.left;
	                } else {
	                    temp = temp.right;
	                }
	                i = i + 1;
	            }
	            stringBuilder.append(temp.symbol);
	        }
	        return stringBuilder.toString();
	    }
	   
	   
	    public static BitSet getBitSet(String eLine)
	    {
	        BitSet bitSet = new BitSet();
	        int i =0;
	        for (i = 0; i < eLine.length();i++)
	        {
	            if (eLine.charAt(i) == '0')
	                bitSet.set(i,false);
	            else
	                bitSet.set(i,true);
	        }
	        bitSet.set(i,true);
	        return bitSet;
	    }
	   

	    
	    public static String printCharMap(Map<Character, String> map) { //Used For Printing the mapping
	        StringBuilder s = new StringBuilder();


	        for (Map.Entry<Character, String> temp : map.entrySet()) {
	           
	            s.append(" " + temp.getKey() + " " + temp.getValue() + "\n");
	        }
	        return s.toString();
	    }

	    
	    
	    
	
	public static BitSet StringToBitSet(String encoded) {
		BitSet bitSet = new BitSet(encoded.length()); //https://stackoverflow.com/questions/4350084/byte-to-file-in-java
		                                              //Converting the encoded String to BitSet
		int bitcounter = 0;
		for(Character c : encoded.toCharArray()) {
		    if(c.equals('1')) {
		        bitSet.set(bitcounter);
		    }
		    bitcounter++;
		}
		
		return bitSet;
	}
	
	
	
	  public static class HuffmanComprator implements Comparator<HuffmanNode> {


	        @Override
	        public int compare(HuffmanNode left, HuffmanNode right) {
	            return left.frequency - right.frequency;

	        }
	    }
	
	
	
	
	
	
}

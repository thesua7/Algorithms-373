package com.nsu.cse373.spring2020.ID1620129;

import java.util.*;


class HuffmanC {


	public static HuffmanNode root;
	
	
	public static void Genarate(String line){
		

		
		  root = buildTree(getCharFreq(line));
	}
	
	
	
	 public static HuffmanNode buildTree(Map<Character, Integer> map) {
	        Queue<HuffmanNode> pq = createNodeQueue(map);

	        while (pq.size() > 1) {
	            HuffmanNode left = pq.remove();
	            HuffmanNode right = pq.remove();
	            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
	            pq.add(parent);
	        }

	        return pq.remove();
	    }
	 
	 
	 
	 public static Queue<HuffmanNode> createNodeQueue(Map<Character, Integer> map) {
	        Queue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(11,new HuffmanComprator()); //initial capacity=11 and a StudentComparator instance
	                                                                  //https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/

	        for (Map.Entry<Character, Integer> m : map.entrySet()) {

	            pq.add(new HuffmanNode(m.getKey(), m.getValue(), null, null));
	        }

	        return pq;

	    }
	 
	 
	  public static Map<Character, Integer> getCharFreq(String sentence)
	    {
	        Map<Character, Integer> charFreq = charecterFrequency(sentence);
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
	
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

	
//	public static void createKeys(BitSet [] keys, HuffmanNode current, BitSet key,int i){
//	
//
//		if(current.isLeaf()){
//			keys[current.getSymbol()] = key;
//
//			
//		}else{
//			createKeys(keys, current.left, key.nextSetBit(i),0);
//			createKeys(keys, current.right, key + "1");
//		}
//	}
	
	
	
	
	
	
	  public static class HuffmanComprator implements Comparator<HuffmanNode> {


	        @Override
	        public int compare(HuffmanNode left, HuffmanNode right) {
	            return left.frequency - right.frequency;

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

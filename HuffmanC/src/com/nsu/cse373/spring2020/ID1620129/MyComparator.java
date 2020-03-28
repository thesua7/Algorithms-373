package com.nsu.cse373.spring2020.ID1620129;

import java.util.Comparator;

class MyComparator implements Comparator<Huffman>{
	
    public int compare(Huffman x, Huffman y) 
    { 
  
        return x.data - y.data; 
    } 
}

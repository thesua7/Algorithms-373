package com.nsu.cse373.spring2020.ID1620129;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

class Main {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String[] MainArray = new String[50000];
		
		
		FileCodes f = new FileCodes();
		f.readFromFile(MainArray);
	    
		int NodeNum = Integer.parseInt(f.getNoOfNode());
		int EdgeNum = Integer.parseInt(f.getNoOfEdge());
		
		
		System.out.println("Number of nodes: "+NodeNum);
		System.out.println("Number of edges "+EdgeNum);
		
		String[] CityNameNode = new String[NodeNum];
		String[] CityEdges = new String[EdgeNum];
		HashMap<String, Integer> map = new HashMap<>(); 
		
		int TotalStrings = NodeNum+EdgeNum;
		
		int i=1;
		int tempIndex1=0;
		int tempIndex2=0;
        while((i<=TotalStrings)&&(MainArray[i]!=null)) {
 
        	String temp = MainArray[i].trim();
      	    String[] words = temp.split(" ");
        	if(words.length<2) {
        	
        		CityNameNode[tempIndex1] = words[0];  //Storing to array
        		map.put(CityNameNode[tempIndex1], tempIndex1); //Storing to Hash
        		tempIndex1++;

        	}
        	
        	else {
        		CityEdges[tempIndex2] = MainArray[i];
        		tempIndex2++;
        	}
        	i++;
	    }

        System.out.println("City Node Names: ");
        for(int k=0;k<CityNameNode.length;k++) {
        	System.out.println(CityNameNode[k]);
        }
        
        
       System.out.println(map); 
        System.out.println("--------------------------------------");
        
        System.out.println("City Node Names: ");
        for(int k=0;k<CityEdges.length;k++) {
        	System.out.println(CityEdges[k]);
        }
        
        
  
        
        System.out.println("---------------xxxxx-----------------------");
        
        
        Graphs G = new Graphs();
        
        tempIndex2=0;
        while(tempIndex2<EdgeNum) {
        	String temp = CityEdges[tempIndex2].trim();
      	    String[] words = temp.split(" ");
      	    G.addEdge(words[0], words[1]);
        	
      	  tempIndex2++;
        }
        
        
       
        G.getVertexCount();
        G.setTempHash(map);
        
        System.out.println(G.toString());
        

        G.BFS("Jakarta");
        System.out.println();
        G.DFS("Jakarta");

        
        
        
        
}

	
}
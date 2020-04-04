	package com.nsu.cse373.spring2020.ID1620129;

class Node {
	  String City;
	  int Index;
	  boolean isVisited;
	  
	  Node next;
	  

	    Node( String City, int Index ) {
	        this.City = City;
	        this.Index = Index;
	    }



	    Node() {
	        this.City = null;
	        this.Index=0;
	        this.isVisited=false;
	        this.next=null;
	    }
}

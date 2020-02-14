package com.nsu.cse373.spring2020.ID1620129;

public class HeapSort {
	  public static <E extends Comparable<E>> void heapSort(E[] inputArray){
	    System.out.println("Executing HeapSort for the following input:");
	    SortHelper.print(inputArray,inputArray.length);
	    System.out.println("------------------------");
	    System.out.println("This is HeapSort\n");
	    HeapSort(inputArray, inputArray.length);
	    System.out.println("------------------------");
	  }
	  
	  /*
	   * You are allowed to change the function signature to whatever you want
	   * but it must take generic type input to be able to sort any array
	   * containing data that can be compared. Look at BubbleSort class for
	   */
	  
	  
	  private static <E extends Comparable<E>> void HeapSort(E[] inputArray, int size){
		    for (int i = size / 2 - 1; i >= 0; i--) {
		    	reheapdown(inputArray, i, size);
		    }
		    for (int i = size - 1; i >= 0; i--) { 
		        E temp = inputArray[0];
		        inputArray[0]=inputArray[i];
		        inputArray[i] = temp;
		   
		        reheapdown(inputArray, 0, i); 
		        SortHelper.print(inputArray, size);
		    } 
	  }
	  
	  private static <E extends Comparable<E>> void reheapdown(E[] inputArray, int index, int size) {
		  	int max = index; 
		    int leftchild = 2 * index + 1; 
		    int rightchild = 2 * index + 2;  
		  
		    
		    if (leftchild < size) {
		    	if(inputArray[leftchild].compareTo(inputArray[max])>0) {
		    		max = leftchild;
		    	}
		    }
		        
		   
		     
		    if (rightchild < size) {
		    	if(inputArray[rightchild].compareTo(inputArray[max]) > 0) {
		    		max = rightchild; 
		    	}
		    }
		        
		  
		    
		    if (max != index) { 
		    	E temp = inputArray[index];
		    	inputArray[index] = inputArray[max];
		    	inputArray[max] = temp;
		        reheapdown(inputArray, max, size); 
		    } 
	  }

	  

	  
	}
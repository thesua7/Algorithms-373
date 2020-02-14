package com.nsu.cse373.spring2020.ID1620129;

public class RecursiveInsertionSort {
  public static <E extends Comparable<E>> void recursiveInsertionSort(E[] inputArray){
    System.out.println("Executing Recursive Insertion Sort for the following input:");
    SortHelper.print(inputArray,inputArray.length);
    System.out.println("------------------------");
    
    
    
    System.out.println("This is recursiveInsertion\n");
    sortInternal(inputArray,inputArray.length);
    SortHelper.print(inputArray, inputArray.length);
    
    System.out.println("------------------------");
  }
  
  /*
   * You are allowed to change the function signature to whatever you want
   * but it must take generic type input to be able to sort any array
   * containing data that can be compared. Look at BubbleSort class for
   */
  private static <E extends Comparable<E>> void sortInternal(E[] inputArray
      , int size){
    //

		if(size<=1)
			return;
		sortInternal(inputArray, size-1);
		
		E swap=inputArray[size-1];
		int i;
		for(i=size-2; i>=0 && inputArray[i].compareTo(swap)>0;i--){
			inputArray[i+1]=inputArray[i];
	}	
		inputArray[i+1]=swap;
	  
	  
		  SortHelper.print(inputArray,size);
	  
	  
	  
	  
  }
}

package com.nsu.cse373.spring2020.ID1620129;

public class RecursiveSelectionSort {
  public static <E extends Comparable<E>> void recursiveSelectionSort(E[] inputArray){
    System.out.println("Executing Recursive Selection Sort for the following input:");
    SortHelper.print(inputArray,inputArray.length);
    System.out.println("------------------------");
    
    System.out.println("This is RecursiveSelection\n");
    sortInternal(inputArray,inputArray.length);
    SortHelper.print(inputArray, inputArray.length);
    System.out.println("------------------------");
    System.out.println("------------------------");
  }
  
  /*
   * You are allowed to change the function signature to whatever you want
   * but it must take generic type input to be able to sort any array
   * containing data that can be compared. Look at BubbleSort class for
   */
  private static <E extends Comparable<E>> void sortInternal(E[] inputArray
      , int size){
	  
	  
	  
	  
	  RecursiveSelectionSort(inputArray,0,size);
	  
	  
	  
	  
	  
    //
  }
  
  
  public static <E extends Comparable<E>> void RecursiveSelectionSort(E[] inputArray,int i,int size) {
	  
	  
	  
	  int max = i;
		
		for(int j=i+1;j<size;j++) {
			if(inputArray[max].compareTo(inputArray[j])>0) {
				max = j;
			}
		}
		
		E temp = inputArray[i];
		inputArray[i] = inputArray[max];
		inputArray[max] = temp;
		
		  SortHelper.print(inputArray,size);
		    
		   if(i+1<size) {
			   RecursiveSelectionSort(inputArray,i+1,size);
		   }
		
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}

package com.nsu.cse373.spring2020.ID1620129;

public class IterativeSelectionSort {
  public static <E extends Comparable<E>> void iterativeSelectionnSort(E[] inputArray){
    System.out.println("Executing Iterative Selection Sort for the following input:");
    SortHelper.print(inputArray,inputArray.length);
    System.out.println("------------------------");

    System.out.println("This is IterativeSelection\n");
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
	  
	  

	  int max=0;
	  
	  for(int i=0;i<size-1;i++) {
		  max=i;
		  for(int j=i+1;j<size;j++) {
			  if(inputArray[j].compareTo(inputArray[max])<0) {
				  max = j;
			  }
		  }
		  E temp = inputArray[i];
		  inputArray[i] = inputArray[max];
		  inputArray[max] = temp;
		  
		  SortHelper.print(inputArray,size);
		  
	  }
	  
	  
	  
	  
  }
}

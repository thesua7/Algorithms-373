package com.nsu.cse373.spring2020.ID1620129;

public class QuickSort {
  public static <E extends Comparable<E>> void quickSort(E[] inputArray){
    System.out.println("Executing QuickSort for the following input:");
    SortHelper.print(inputArray,inputArray.length);
    System.out.println("------------------------");
   
    System.out.println("This is QuickSort\n");
    quickSort(inputArray, 0, inputArray.length-1);
    

    SortHelper.print(inputArray,inputArray.length);
    System.out.println("------------------------");
  }
  
  /*
   * You are allowed to change the function signature to whatever you want
   * but it must take generic type input to be able to sort any array
   * containing data that can be compared. Look at BubbleSort class for
   */  
  public static<E extends Comparable<E>> void quickSort(E[] inputArray,int firstIndex,int lastIndex){

     if(firstIndex<lastIndex) {
    	 int pivot = partition(inputArray,firstIndex,lastIndex);
         quickSort(inputArray,firstIndex,pivot-1);
         quickSort(inputArray,pivot+1,lastIndex);
     }

      
	  
	  
  }
  
  
  
  
  
  private static <E extends Comparable<E>> int partition(E[] inputArray
	      , int left,int right){
		  
	  int partitionpoint = left;
	  

	  int forwardIndex = left+1;
	  int backwardIndex = right;
	  

	  
	  E pivot = inputArray[partitionpoint];
	  
	  while(forwardIndex < backwardIndex) {
		  
	
	
		  while(inputArray[forwardIndex].compareTo(pivot)<0) {
			  forwardIndex++;
		  }

		  
		  while(inputArray[backwardIndex].compareTo(pivot)>0) {
			  backwardIndex--;
		  }
		  

		  
		  if(forwardIndex<backwardIndex) {
			  E temp = inputArray[forwardIndex];
			  inputArray[forwardIndex] = inputArray[backwardIndex];
			  inputArray[backwardIndex] = temp;
		  }
		  
	  }
		  
		 SortHelper.print(inputArray, inputArray.length);
		  
		  while(backwardIndex>partitionpoint && inputArray[backwardIndex].compareTo(pivot)>0) {
			  backwardIndex--;
		  }

		  
		  SortHelper.print(inputArray, inputArray.length);
		  

		  
		  if(inputArray[backwardIndex].compareTo(pivot) < 0) {
			  inputArray[partitionpoint] = inputArray[backwardIndex];
			  inputArray[backwardIndex] = pivot;
			  partitionpoint = backwardIndex;
			  
		  }
	
	  return partitionpoint;
	  
	  }
  
  
 
  
  
  
  
  
  
  
}

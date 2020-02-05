package com.nsu.cse373.spring2020.ID1620129;

import java.util.Arrays;

public class MergeSort {
  public static <E extends Comparable<E>> void mergeSort(E[] inputArray){
    System.out.println("Executing MergeSort for the following input:");
    SortHelper.print(inputArray,inputArray.length);
    System.out.println("------------------------");
 
    sortInternal(inputArray,inputArray.length);
    System.out.println("This is MergeSort\n");
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
	  
	  mergeSort(inputArray,0,size-1);
	  
    //
  }
  
  

	public static <E extends Comparable<E>> void mergeSort(E ar[], int left, int right){

	    if(left >= right){
	        return ;
	    }

	    int mid = (left + right) / 2;

	    mergeSort(ar, left, mid);
	    mergeSort(ar, mid + 1, right);
	    merge(ar, left, right);
	    SortHelper.print(ar,right);

	}

	
	
	static <E extends Comparable<E>> void merge(E ar[], int left, int right){

		    int mid = (left + right) / 2;
		    
		    int length = right - left + 1;

		     E[] temp = Arrays.copyOf(ar,length); //Getting errors while I'm declaring a Generic type Array so I just copied it to not to get compile errors
		
		//    E[] temp = (E[]) new Object();

		    int size1 = left;
		    int size2 = mid + 1;

		    int i = size1;
		    int j = size2;
		    int p = 0;
		    while(i <= mid  && j <= right){
		        if(ar[i].compareTo(ar[j])>0){
		            temp[p] = ar[j];
		            j++;
		            p++;
		        }
		        else{
		            temp[p] = ar[i];
		            i++;
		            p++;
		        }
		    }
		    

		    while(i <= mid){
		            temp[p] = ar[i];
		            p++;
		            i++;
		    }
		    while(j <= right){
		            temp[p] = ar[j];
		            p++;
		            j++;
		    }
		    

		    for(int k = 0; k < temp.length; k++){
		        ar[left + k] = temp[k];
		    }
		}
  
  
  
  
	
  
  
  
  
  
  
}

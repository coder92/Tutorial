package com.tutorial.ds.sorting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;


/**
 * Merge sort is stable sorting technique. 
 * Should be used in Object sorting. 
 * Extra space used.
 * 
 * @author Ankit.Dixit
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		
		 
	    System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m");
		
		MergeSort ms = new MergeSort();
		List<Integer> list = new ArrayList<Integer>();
		int max = 1000;
		int[] arr = new int[max];
		Random r = new Random();
		for(int i=0;i<max;i++) {
			//list.add(r.nextInt());
			
			arr[i]=r.nextInt(100);
		}
		
		/*System.out.println("List Before Sorting>>");
		System.out.println(list);
		
		list = ms.mergeSort(list);
		System.out.println("List After Sorting>>");
		System.out.println(list);*/
		
		System.out.println("======Array Implementation=====");
		System.out.println("Array Before Sorting>>");
		printArray(arr);
		
		
		long startTime = Calendar.getInstance().getTimeInMillis();
		ms.mergeSort(arr, 0, arr.length-1);
		long endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("Total Time for execution::"+(endTime-startTime));
		System.out.println("Array After Sorting>>");
		printArray(arr);
	}

	//List implementation
	private List<Integer> mergeSort(List<Integer> A) {
		
		return null;
	}
	
	
	//Array Implementation
	void merge(int arr[], int l, int m, int r) 
    { 
		//System.out.println("merge::l="+l+" m="+m+" r="+r);
		//printArray(arr);
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        
        //System.out.println("merge: sort:");
        //printArray(arr);
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void mergeSort(int arr[], int l, int r) 
    { 
    	
    	/*System.out.println("mergeSort::arr::l="+l+"  r="+r);
    	printArray(arr);*/
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  

}

package com.tutorial.ds.sorting;

import com.tutorial.common.CommonClass;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 * 
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation. 
 * 
 * @author Ankit.Dixit
 *
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] A = {12, 343, 12, 2132, 32, 3231, 31};
		SelectionSort ss = new SelectionSort();
		
		CommonClass.printMessage("Before Sorting");
		CommonClass.printArray(A);
		ss.selectionSort(A);
		CommonClass.printMessage("After Sorting");
		CommonClass.printArray(A);
	}
	
	public void selectionSort(int[] A) {
		
		for(int i=0;i<A.length;i++) {
			 swap(A, i, findMin(A, i, A.length-1));
		}
	}
	
	private void swap(int[] A, int i, int minIndex) {
		int temp = A[i];
		A[i] = A[minIndex];
		A[minIndex] = temp;		
	}

	private int findMin(int[] A, int s, int e) {
		int minIndex=s;
		for(int j=s+1;j<=e;j++) {
			if(A[j]<A[minIndex])
				minIndex = j;
		}
		return minIndex;
	}
}

package com.tutorial.ds.sorting;

import com.tutorial.common.CommonClass;

/**
 * {@link https://www.geeksforgeeks.org/insertion-sort/}
 * 
 * @author Ankit.Dixit
 *
 */
public class InsertionSort {
	
	public static void main(String[] args) {
		int[] A = {12, 343, 12, 2132, 32, 3231, 31};
		InsertionSort is = new InsertionSort();
		
		CommonClass.printMessage("Before Sorting");
		CommonClass.printArray(A);
		is.insertionSort(A);
		CommonClass.printMessage("After Sorting");
		CommonClass.printArray(A);
	}
	
	public void insertionSort(int[] A) {
		int j;
		for(int i=1;i<A.length;i++) {
			int key = A[i];
			for(j=i-1;j>=0;j--) {
				if(A[j]>key) {
					A[j+1] = A[j];
				}else
					break;
			}
			A[j+1] = key;
			CommonClass.printMessage("Array after i="+i);
			CommonClass.printArray(A);
		}
	}
}

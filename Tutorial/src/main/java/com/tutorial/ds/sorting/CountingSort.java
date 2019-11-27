package com.tutorial.ds.sorting;

import com.tutorial.common.CommonClass;

/**
 * https://www.geeksforgeeks.org/counting-sort/
 * <br>
 * 
<br>Counting sort is a sorting technique based on keys between a specific range. 
<br>It works by counting the number of objects having distinct key values (kind of hashing). 
<br>Then doing some arithmetic to calculate the position of each object in the output sequence.
<br>
<br>Let us understand it with the help of an example.
<br>
<br>For simplicity, consider the data in the range 0 to 9. 
<br>Input data: 1, 4, 1, 2, 7, 5, 2
<br>1) Take a count array to store the count of each unique object.
<br>Index:     0  1  2  3  4  5  6  7  8  9
<br>Count:     0  2  2  0   1  1  0  1  0  0
<br>
<br>  2) Modify the count array such that each element at each index 
<br>  stores the sum of previous counts. 
<br>  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

<p>
The modified count array indicates the position of each object in 
the output sequence.
</p> 
  3) Output each object from the input sequence followed by 
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place 
  next data 1 at an index 1 smaller than this index.
 * <br>
 * @author Ankit.Dixit
 *
 *Notes
 *O(n) if elements are in 0 to n
 *
 */
public class CountingSort {
	public static void main(String[] args) {
		int[] arr = {10,2,34,5,6,6,5,4};
		System.out.println("before sorting");
		CommonClass.printArray(arr);
		int n=1000;
		arr = sort(arr,n);
	}
	
	public static int[] sort(int[] arr, int n) {
		int[] C = new int[n];
		int[] B = new int[arr.length];
		
		System.out.println("Array before sorting----->");
		CommonClass.printArray(arr);
		
		for(int i=0;i<n;i++) {
			C[i] =0;
		}
		
		for(int i=0;i<arr.length;i++) {
			C[arr[i]]++; 
		}
		
		CommonClass.printMessage("Counting array");
		CommonClass.printArray(C);
		
		for(int i=1;i<n;i++) {
			C[i] += C[i-1];
		}
		
		CommonClass.printMessage("Counting array after positioning");
		CommonClass.printArray(C);
		
		for(int i=0;i<arr.length;i++) {
			B[C[arr[i]]-1] = arr[i];
			C[arr[i]]--;
		}
		CommonClass.printMessage("Sorted Array");
		CommonClass.printArray(B);
		return B;
	}
}

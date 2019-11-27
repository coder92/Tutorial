package com.tutorial.ds.sorting;

import com.tutorial.common.CommonClass;

import java.util.Arrays;

/**
<p>
We can’t use counting sort because counting sort will take O(n2) which is worse than comparison based sorting algorithms. Can we sort such an array in linear time?
Radix Sort is the answer. 
</p>
<p>
What is the running time of Radix Sort?
Let there be d digits in input integers. Radix Sort takes O(d*(n+b)) time where b is the base for representing numbers, for example, for decimal system, b is 10. What is the value of d? If k is the maximum possible value, then d would be O(logb(k)). So overall time complexity is O((n+b) * logb(k)). Which looks more than the time complexity of comparison based sorting algorithms for a large k. Let us first limit k. Let k <= nc where c is a constant. In that case, the complexity becomes O(nLogb(n)). But it still doesn’t beat comparison based sorting algorithms.
What if we make value of b larger?. What should be the value of b to make the time complexity linear? If we set b as n, we get the time complexity as O(n). In other words, we can sort an array of integers with range from 1 to nc if the numbers are represented in base n (or every digit takes log2(n) bits).  
</p>
<p>

</p>
 * @author Ankit.Dixit
 * {@link https://www.geeksforgeeks.org/radix-sort/}
 * 
 */
public class RadixSort {
	
	public static void main(String[] args) {
		RadixSort radixSort = new RadixSort();
		
		int[] A = {123, 252, 25, 272, 43, 0, 2};
		radixSort.radixSort(A);
	}
	
	public void radixSort(int[] A) {
		
		int max = A[0];
		
		for(int i=1;i<A.length;i++) {
			if(A[i]>max)
				max = A[i];
		}
		
		CommonClass.printMessage("before sorting");
		CommonClass.printArray(A);
		
		for(int exp =1; max/exp>0;exp *= 10) {
			countingSort(A, exp);
			CommonClass.printMessage("after exp="+exp);
			CommonClass.printArray(A);
		}
	}
	
	private void countingSort(int[] A, int exp) {
		int output[] = new int[A.length];
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		//store occurance 
		for(int i=0;i<A.length;i++) {
			count[ ( A[i]/exp )%10 ]++;
		}
		
		//actual position
		for(int i=1;i<10;i++) {
			count[i] += count[i-1];
		}
		
		
		//put values in output
		for(int i=A.length-1;i>=0;i--) {
			output[count[(A[i]/exp)%10]-1] = A[i];
			count[(A[i]/exp)%10]--;
		}
		
		//copy entries in original Array
		for(int i=0;i<A.length;i++) {
			A[i] = output[i];
		}
	}
}

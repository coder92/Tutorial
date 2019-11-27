package com.tutorial.ds.sorting;

import java.util.Random;

/**
 * this algo provide time complexity O(n^2)
 * array is traversed from first element to last element. 
 * Here, current element is compared with the next element. 
 * If current element is greater than the next element, it is swapped.
 * @author Ankit.Dixit
 */
public class BubbleSort{

	public static void main(String[] args) {
		int n=5;
		int[] A = new int[n];
		Random r = new Random();
		for(int i=0;i<n;i++) {
			A[i] = r.nextInt(100);
		}
		//sorting algorithm 
		System.out.println("----Before Sorting----");
		printArray(A);
		
		A = bubbleSortAlgo(A);
		System.out.println("\n----After Sorting----");
		printArray(A);
		
		
	}

	private static void printArray(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" | ");
		}
		System.out.println();
	}

	/**
	 * Pseudo code 
	 * {
	 * 	max element of remaining elements will be in the last after every iteration.
	 * }
	 * 
	 *DryRun
	 *{
	 * 3,60,35,2,45,320,5
	 * 3,60; 60, 35-> 35,60;60,2->2, 60; 60,45->45, 60; 60,320;320,5->5,320;
	 * 3,35,2,45,60,5,320;
	 * 3,35|35,2->2,35|35,45|45,60|60,5->5,60
	 * 3,2,35,45,5,60,320
	 * 3,2->2,3|3,35|35,45|45,5->5,45| 
	 * 2,3,35,5,45,60,320	
	 * 
	 *}
	 * 
	 * @param A
	 * @return
	 */
	private static int[] bubbleSortAlgo(int[] A) {
		int tmp;
		System.out.println("bubbleSortAlgo implementation");
		for(int i=A.length-1;i>=0;i--) {
			printArray(A);
			for(int j=0;j<i;j++) {
				if(A[j]>A[j+1])
				{
					tmp = A[j+1];
					A[j+1] = A[j];
					A[j] = tmp;
				}
				
			}
		}
		
		return A;
	}
	
	/*
	 * this improved the time complexity to O(n) in best case 
	 * this could also be used to check the list is already sorted 
	 * or not in O(n) time.
	 */
	private static int[] bubbleSortImproved(int[] A) {
		
		int tmp;
		boolean swapped = true;
		
		for(int i=A.length-1;i>=0 && swapped;i--) {
			swapped = false;
			for(int j=0;j<=i;j++) {
				if(A[j]>A[j+1]) {
					tmp = A[j];
					A[j] = A[j+1];
					A[j+1] = tmp;
					swapped = true;
				}
			}
		}
		
		return A;
	}
}

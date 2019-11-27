package com.tutorial.ds.array.problems;

import com.tutorial.common.CommonClass;

/**
 * @see https://practice.geeksforgeeks.org/problems/reversal-algorithm/0/?ref=self
 * <p>
 * Given an array of N size. The task is to rotate array by d elements where d is less than or equal to N.

Input:
The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of three lines. The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements. The third line of each test case contains "d" .

Output:
Corresponding to each test case, in a new line, print the modified array.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 200
1 ≤ A[i] ≤ 1000

Example:
Input
1
5
1 2 3 4 5
2

Output
3 4 5 1 2
 * </p>
 * @author Ankit.Dixit
 *
 */
public class RotatingAnArray {
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		int rotations = 8;
		RotatingAnArray obj = new RotatingAnArray();
		obj.rotateArray(A, rotations);
		CommonClass.printArray(A);
	}

	private void rotateArray(int[] A, int rotations) {
		int n = A.length;
		int output[] = new int[n];
		
		int actualRotations = rotations%n;
		
		if(actualRotations ==0)
			return;
		
		int j=0;
		for(int i=actualRotations;i<n;i++) {
			output[j++] = A[i];
		}
		for(int i=0;i<actualRotations;i++) {
			output[j++] = A[i];
		}
		
		for(int i=0;i<n;i++) {
			A[i] = output[i];
		}
	}
}

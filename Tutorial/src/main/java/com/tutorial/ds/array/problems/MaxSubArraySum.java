/*
https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous 

*/

package com.tutorial.ds.array.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxSubArraySum {
	
	public static void main(String[] args) {
		MaxSubArraySum classObj = new MaxSubArraySum();
		classObj.takeInput();
		
	}

	private void takeInput() {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int t = Integer.parseInt(br.readLine());
			int arr[];
			int n;
			
			while(t-->0) {
				n = Integer.parseInt(br.readLine());
				arr = integerArrFromString(br.readLine(), n);
				
				int maxSubArraySum = maxSubArraySum(arr, n);
				System.out.println(maxSubArraySum);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int maxSubArraySum(int[] arr, int n) {
		int max = arr[0];
		int tm = arr[0];
		for(int i=1;i<n;i++) {
			max = Math.max(max, 0)+arr[i];
			tm = (tm>=arr[i])?tm:arr[i];
		}
		return (max>=0?max:tm);
	}

	private int[] integerArrFromString(String arrStr, int n) {
		int st =0, en=0;
		int arrIndex =0;
		int[] arr = new int[n];
		
		while(en>=0) {
			en = arrStr.indexOf(' ', st);
			arr[arrIndex++] = Integer.parseInt(arrStr.substring(st, en));
			st = en+1;
		}
		return arr;
	}
}

/*
 * https://practice.geeksforgeeks.org/problems/count-the-triplets/0
 * 
 * Given an array of distinct integers. The task is to count all the triplets such that sum of two 
 * elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. Each test case consists of two lines. 
First line of each test case contains an Integer N denoting size of array and the second line contains 
N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 10^5
1 <= A[i] <= 10^6

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

 */

/*
 * Pseudo code 
 * a+b = c
 * put all element in hashmap.
 * 
 * pick one element and then pick all other element one by one and take the sum and put 
 * that sum in the hashmap with key = element and value  = sum
 * 
 * HM - [1=0, 5=0, 3=0, 2=0];
 *1
 * 	5 - 1+5 = 6 check 6 in hash map
 * 	3 - 4 => 
 * 	2 - 3 => yes 
 *5
 * 	3 - 8 
 * 	2 - 7 
 *3
 *	2 - 5 =>yes	
 */
package com.tutorial.ds.array.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountTheTripltes {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int t = Integer.parseInt(br.readLine());
		    int n;
		    while(t-->0){
		    	n = Integer.parseInt(br.readLine());
		    	
		    	String[] inputs = br.readLine().split(" ");
		    	int[] arr = new int[n];
		    	for(int i=0;i<n;i++) {
		    		arr[i] = Integer.parseInt(inputs[i]);
		    	}
		    	System.out.println(countTriplets(arr,n));
		    }
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static int countTriplets(int[] arr, int n) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int count=0;
		
		for(int i=0;i<n;i++) {
			map.put(arr[i], 0);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=i+1; j<n;j++) {
				if(map.get(arr[i]+arr[j])!=null) {
					count++;
				}
			}
		}
		return (count==0)?-1:count;
	}	
}

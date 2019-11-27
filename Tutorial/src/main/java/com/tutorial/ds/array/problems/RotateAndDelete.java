package com.tutorial.ds.array.problems;

/**
 * <p>
 * Given an array arr[] of N integers. Do the following operation n-1 times. For every Kth operation:

    Right rotate the array clockwise by 1.
    Delete the (n-k+1)th last element.

Now, find the element which is left at last.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follows. Each test case contains two lines. The first line of each test case contains an integer N. Then in the next line are N space separated values of the array arr[].

Output:
For each test case in a new line print the required result.

Constraints:
1 <= T <= 110
1 <= N <= 106
1 <= A[i] <= 107

Example:
Input
2
4
1 2 3 4
6
1 2 3 4 5 6

Output:
2
3

Explanation:
Testcase 2: A = {1, 2, 3, 4, 5, 6}. Rotate the array clockwise i.e. after rotation the array A = {6, 1, 2, 3, 4, 5} and delete the last element that is {5} so A = {6, 1, 2, 3, 4}. Again rotate the array for the second time and deletes the second last element that is {2} so A = {4, 6, 1, 3}, doing these steps when he reaches 4th time, 4th last element does not exists so he deletes 1st element ie {1} so A={3, 6}. So continuing this procedure the last element in A is {3}, so outputp will be 3.
 * </p>
 * @see https://practice.geeksforgeeks.org/problems/rotate-and-delete/0
 * @author Ankit.Dixit
 *
 */
public class RotateAndDelete {
	public static void main(String[] args) {
		RotateAndDelete obj = new RotateAndDelete();
		int[] A = {1, 2, 3, 4, 5, 6};
		
		System.out.println(obj.rotateAndDelete(A));
	}
	private int rotateAndDelete(int[] A){
		int n = A.length;
		if(n==1 || n==2|| n==3) {
			return A[n-1];
		}
		
		if(n%2==0) {
			return (int) (Math.ceil(n/4)+1);
		}else {
			return (int) (Math.ceil(n-1/4)+2);
		}
	}
}

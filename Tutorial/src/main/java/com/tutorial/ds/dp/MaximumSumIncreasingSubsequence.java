package com.tutorial.ds.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
/**
 * Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3
 * @author ankit
 *
 */
public class MaximumSumIncreasingSubsequence {

    
	public static void main (String[] args)
	 {
	   try{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.parseInt(br.readLine().trim());
	    int n;
	    int[] A;
	    while(t-->0){
	        n = Integer.parseInt(br.readLine().trim());
	        String[] inputLine = br.readLine().trim().split(" ");
	        A = new int[n];
	        for(int i=0;i<n;i++){
	            A[i] = Integer.parseInt(inputLine[i]);
	        }
	       System.out.println(msis(A,n));    
	   }
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	 }
	 
	 
	 static int msis(int[] arr, int n){
	        
	     int[] msis = new int[n];
	     
	     
	     msis[0]=arr[0];
	     
	 
	     for(int i=1;i<n;i++){
	         msis[i] = arr[i];
	         
	         for(int j=0;j<i;j++){
	             if(arr[i]>arr[j] && msis[i] < msis[j]+arr[i]){
	                 msis[i] = msis[j]+arr[i];
	             }
	         }
	         
	     }
	     int ms=arr[0];
	     for(int i=1;i<n;i++){
	         if(msis[i]>ms)
	            ms = msis[i];
	     }
	     return ms;
	 }

}

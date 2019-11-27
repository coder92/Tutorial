package com.tutorial.ds.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
/*
2
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
6
5 8 3 7 9 1
 */
public class LongestIncreaseSubsequence {

    
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
	       
	       System.out.println(LIS(A,n));
	   }
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	 }
	 
	 public static int LIS(int[] arr, int n){
	     int[] lis = new int[n];
	     
	     lis[0] = 1 ;
	     
	     for(int i=1;i<n;i++){
	         lis[i]=1;
	         for(int j=0;j<i;j++){
	             if(arr[i]>arr[j] && lis[i] <lis[j]+1 ){
	                 lis[i] = lis[j]+1;
	             }
	         }
	     }
	     
	     int max=lis[0];
	     for(int i=1;i<n;i++){
	         if(max< lis[i]) max = lis[i];
	     }
	     return max;
	 }

}

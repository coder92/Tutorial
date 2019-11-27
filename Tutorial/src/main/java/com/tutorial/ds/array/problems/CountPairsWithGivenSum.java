package com.tutorial.ds.array.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * {@link https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum/0}
 * @author Ankit.Dixit
 *
 */
public class CountPairsWithGivenSum {
	public static void main (String[] args)
	 {
	   try{
		   CountPairsWithGivenSum obj = new CountPairsWithGivenSum();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.parseInt(br.readLine().trim());
	    int n, k;
	    int[] A;
	    while(t-->0){
	        String[] input1 = br.readLine().split(" ");
	       
	        n = Integer.parseInt(input1[0]);
	        k = Integer.parseInt(input1[1]);
	        String[] inputLine = br.readLine().split(" ");
	        A = new int[n];
	        
	        int j=0;
	        for(int i=0;i<inputLine.length;i++){
	            if(inputLine[i].equals(""))
	                continue;
	            A[j++] = Integer.parseInt(inputLine[i]);
	        }
	        System.out.println(obj.countPairsWithGivenSum(A, n, k));
	           
	   }
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	 }
	
	/**
	 *	
	 * @param A
	 * @param n
	 * @param k
	 * @return
	 * 
	 * 
	 * 
	 * 
	 */
	/*
	 * Input:
		1
		43 44
		46 22 14 97 22 67 30 95 23 30 6 17 40 69 60 97 70 66 45 32 13 4 74 40 61 49 2 23 96 55 17 93 28 30 41 2 96 70 96 18 51 53 86
		
		Its Correct output is:
		6
		
		And Your Code's output is:
		5
		
		
	 */
	public int countPairsWithGivenSum(int[] A, int n, int k){
	     int count=0;
	     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	     for(int i=0;i<n;i++){
	         if(map.get(A[i])!=null){
	             map.put(A[i], map.get(A[i])+1);
	         }else{
	            map.put(A[i], 1);    
	         }
	     }
	     System.out.println(map);
	     for(int i=0;i<n;i++){
	         if(k>=A[i] && map.get(k-A[i])!=null){
	        	 if(k-A[i] == A[i])
	        		 count --;
	             count += map.get(k-A[i]);
	             map.remove(A[i]);
	         }
	     }
	     return count;
	 }
}

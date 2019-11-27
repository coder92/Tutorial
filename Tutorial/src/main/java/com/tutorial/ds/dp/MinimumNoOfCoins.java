package com.tutorial.ds.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0

/*
1
43
 */
public class MinimumNoOfCoins {

    int[] arr={1,2,5,10,20,50,100,200, 500, 2000};
	 int[] intArr= new int[2001];
	 int l=10;
   
	public static void main (String[] args)
	 {
	   try{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    MinimumNoOfCoins obj = new  MinimumNoOfCoins();
	    int t = Integer.parseInt(br.readLine().trim());
	    int n;
	    
	    while(t-->0){
	        n = Integer.parseInt(br.readLine().trim());
	        obj.minCoin(n);
	           
	   }
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	 }

	 public void minCoin(int n){
	     initialiseIntervalArr();
	     
	     while(n!=0){
	     int i = search(n);
	     int t = n/i;
	     n=n%i;
	     for(int j=0;j<t;j++)
	        System.out.print(i+" ");  
	     }
	     System.out.println();
	 }
	 
	 public void initialiseIntervalArr(){
	     
	     for(int i=0;i<l-1;i++){
	         for(int j=arr[i];j<arr[i+1];j++){
	             intArr[j]=arr[i];
	             
	         }
	     }
	 }
	 
	 public int search(int n){
	     if(n>=2000)
	      return 2000;
	     
	     return intArr[n];
	 }

}

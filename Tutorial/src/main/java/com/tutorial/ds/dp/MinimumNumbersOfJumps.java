	package com.tutorial.ds.dp;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	
	//https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0
	public class MinimumNumbersOfJumps {
	    
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
		       System.out.println(MNJ(A,n));    
		   }
		   }catch(Exception e){
		    e.printStackTrace();
		   }
		 }
		 
		 static int MNJ(int[] arr, int n){
		    int[] mnj = new int[n];
		    
		    mnj[n-1]=0;
		    
		    for(int i=n-2;i>=0;i--){
		        if(arr[i]>=(n-1-i)){
		            mnj[i]=1;
		        }else{
		            mnj[i]=Integer.MAX_VALUE;
		            for(int j=i+1;j<=i+arr[i];j++){
		                if(mnj[j]>=0 && mnj[j] < mnj[i]){
		                    mnj[i] = mnj[j];
		                }
		            }
		            
		            if(mnj[i]==Integer.MAX_VALUE){
		                mnj[i]=-1;
		            }else
		                mnj[i]++;
		        } 
		    }
		    return mnj[0];
		 }
	}

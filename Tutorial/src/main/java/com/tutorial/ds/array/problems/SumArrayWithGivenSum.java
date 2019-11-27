package com.tutorial.ds.array.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SumArrayWithGivenSum
 {
    
	public static void main (String[] args) throws IOException
	 {
	    SumArrayWithGivenSum obj = new SumArrayWithGivenSum();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.parseInt(br.readLine());
	    
	    int n, sum;
	    int[] arr;
	    
	    while(t-->0){
	        int i=0;
	        String[] line2 = br.readLine().split(" ");
	        
	        n = Integer.parseInt(line2[0]);
	        sum = Integer.parseInt(line2[1]);
	        
	        arr = new int[n];
	        for(String input: br.readLine().split(" ")){
	            arr[i++] = Integer.parseInt(input);
	        }
	        
	        System.out.println(obj.subArrayWithGivenSum(arr,n, sum));
	    }
	 }
	 
	 private String subArrayWithGivenSum(int[] arr, int n, int sum){
	     StringBuilder sumArrString = new StringBuilder();
	     
	     //logic
	     int arrSum = 0;
	     int a=-1, b=-1;
	     
	     for(int i=0;i<n;i++){
	         arrSum = arr[i];
	        for(int j=i+1;j<n;j++){
	            arrSum += arr[j];
	            if(arrSum>sum)
	                break;
	                
	            if(arrSum == sum)
	                {
	                    if(j-i > b-a)
	                    {
	                        a = i;
	                        b = j;    
	                    }
	                    
	                }
	        }    
	     }
	     if(a==-1)
	        sumArrString.append("-1");
	     else{
	         a++;
	         b++;
	         sumArrString.append(a+" "+b);
	     } 
	        
	     return sumArrString.toString();
	 }
}
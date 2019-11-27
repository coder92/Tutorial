package com.tutorial.ds.dp;

import java.util.Arrays;

/**
 * {@linkplain https://practice.geeksforgeeks.org/problems/find-optimum-operation/0}
 * @author Ankit.Dixit
 *
 */
public class MinimumOperations {
	
	public static void main(String[] args) {
		MinimumOperations obj = new MinimumOperations();
		
		for(int i=0;i<10;i++)
			System.out.println(obj.minOperations(i));
	}
	
	private int minOperations(int n){
		   if(n==0)
		        return 0;
		   if(n==1)
		        return 1;
		   if(n==2)
		    return 2;
		    
		    int[] mo = new int[10000];
		    
		    Arrays.fill(mo, 0);
		    
		    mo[0]=0;
		    mo[1] = 1;
		    mo[2] =2;
		   
		   mo[3] = minOperationsRec(n, 3, mo)+3;
		   mo[4] = minOperationsRec(n, 4, mo)+3;
		   
		   return (int)Math.min(mo[3], mo[4]);
		   
		 }
		 
		 private int minOperationsRec(int n, int s, int[] mo){
		     
		     if(mo[s]!=0)
		        return mo[s];
		     
	         int p = s+1;
	         int m = s*2;
		     
		     if(p==n || m==n){
		         mo[s]=1;
		     }
		    
		     if(m<n && p<n)
		        mo[s] = (int)Math.min(minOperationsRec(n, p, mo), minOperationsRec(n, m, mo) )+1;
		     else if(m<n && p>n)
		        mo[s] = minOperationsRec(n, m, mo)+1;
		     else if(m>n && p<n)
		        mo[s] = minOperationsRec(n, p, mo)+1;
		   
		    return mo[s];
		 }
}

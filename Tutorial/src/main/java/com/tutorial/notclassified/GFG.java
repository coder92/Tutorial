package com.tutorial.notclassified;

/*package whatever //do not write package name here */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GFG {
	public static void main (String[] args) 
	{
		Scanner s  = new Scanner(System.in);
		
		int t = s.nextInt();
		int n;
		int[] A;
		int v;
		while(t-->0)
		{
		    n = s.nextInt();
		    s.next().toCharArray();
		    A = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        A[i] = s.nextInt();
		    }
		    v = s.nextInt();
		    
		    
		    //main logic
		    //no of group of 4 elements in A whose sum is v 
		    
		    int numGroup = sum4(A, v);
		    
		    System.out.println(numGroup);
		}
	}
	
	public static int sum4(int[] A, int v)
	{
	 HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	 ArrayList<Integer> list;
	 for(int i=0;i<A.length;i++)
	 {
	     for(int j=i+1;j<A.length;j++)
	     {
	         int temp= A[i]+A[j];
	         if(map.get(temp) == null)
	         {
	            list = new ArrayList<Integer>();
    	        list = new ArrayList<Integer>();
	            list.add(A[i]);
	            list.add(A[j]);
	            map.put(temp, list);   
	            A[i] =0;
	            A[j] =0;
	         }
	         else
	         {
	             list = map.get(temp);
	             list.add(A[i]);
	             list.add(A[j]);
	         }
	     }
	 }
	 
	 for(int key: map.keySet())
	 {
	     if(map.get(v-key)!=null)
	     {
	         return 1;
	     }
	 }
	 
	 return 0;
	}
}
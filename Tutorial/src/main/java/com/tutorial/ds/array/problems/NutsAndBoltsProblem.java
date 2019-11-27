package com.tutorial.ds.array.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem/0
 * @author Ankit.Dixit
 *
 */
public class NutsAndBoltsProblem {
	public static void main (String[] args)
	 {
	   try{
		NutsAndBoltsProblem obj = new NutsAndBoltsProblem();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.parseInt(br.readLine().trim());
	    int n;
	    String[] inp1;
	    String[] inp2;
	    while(t-->0){
	        n = Integer.parseInt(br.readLine().trim());
	        inp1 = br.readLine().trim().split(" ");
	        inp2 = br.readLine().trim().split(" ");
	        
	        obj.printInOrder(n, inp1, inp2);
	   }
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	 }
	 
	 private void printInOrder(int n, String[] inp1, String[] inp2){
	    HashSet<Character> set1 = new HashSet<Character>();
       HashSet<Character> set2 = new HashSet<Character>();
       
       for(int i=0;i<n;i++){
           set1.add(inp1[i].charAt(0));
           set2.add(inp2[i].charAt(0));
       }
	    
	    // ! # $ % & * @ ^ ~ 
	    
	    char[] chArr = {'!', '#','$', '%', '&', '*', '@', '^', '~'};
	    
	    StringBuilder sb = new StringBuilder();
	    
	    
	    for(int i=0;i<9;i++){
	    	
	        if(set1.contains(chArr[i]) && set2.contains(chArr[i]))
	            sb.append(chArr[i]+" ");
	    }
	    System.out.println(sb.toString().trim());
	    System.out.println(sb.toString().trim());
	 }
}

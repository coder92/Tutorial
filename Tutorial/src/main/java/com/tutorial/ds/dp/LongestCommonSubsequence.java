package com.tutorial.ds.dp;

//https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
/**
 * 
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC
 * @author ankit
 *
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestCommonSubsequence {

    static String X,Y;
	public static void main (String[] args)
	 {
	   try{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = Integer.parseInt(br.readLine().trim());
	    int n,m;
	    int[] A;
	    while(t-->0){
	        String[] inputLine = br.readLine().trim().split(" ");
            n = Integer.parseInt(inputLine[0]);
            m = Integer.parseInt(inputLine[1]);
            
            X =  br.readLine().trim();
            Y = br.readLine().trim();
            
            System.out.println(lcs(n,m));
	           
	   }
	   }catch(Exception e){
	    e.printStackTrace();
	   }
	 }
	 
	 static int lcs(int n, int m){
	     int mat[][] = new int[n+1][m+1];
	     
	     for(int i=0;i<=n;i++){
	         for(int j=0;j<=m;j++){
	             
	             if(i==0 || j==0)
	                mat[i][j] = 0;
	             else{
	                 if(X.charAt(i-1)==Y.charAt(j-1)){
	                     mat[i][j] = mat[i-1][j-1]+1;
	                 }else{
	                     mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
	                 }
	             }

	         }
	     }
	     return mat[n][m];
	 }

}

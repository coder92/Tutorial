 /*
    Fredo and Array Update Fredo is assigned a new task today.  He is given an array A containing N integers. 
    His task is to update all elements of array to some minimum value x , 
    that is,  ;  such that sum of this new array is strictly greater than the sum of the initial array. 
    Note that x should be as minimum as possible such that sum of the new array is greater than the sum of the initial array.

    Input Format:
    First line of input consists of an integer N denoting the number of elements in the array A.
    Second line consists of N space separated integers denoting the array elements.

    Output Format:
    The only line of output consists of the value of x.

    Input Constraints:


    SAMPLE INPUT 
    5
    1 2 3 4 5
    SAMPLE OUTPUT 
    4
*/  

/*
 * Pseado code
 * 
 */

package com.tutorial.ds.array.problems;

import java.util.Scanner;

public class Program1 {

	   public static Scanner s = new Scanner(System.in);    
	    public static void main(String args[] ) throws Exception {
	     
	        //comDivFn();
	        prog1();
	    }
	    

	    public static void prog1(){
	     { 

	        int n = s.nextInt();
	        int[] arr = new int[n];
	        int sum =0;
	        for(int i=0;i<n;i++){
	            arr[i] = s.nextInt();
	            sum += arr[i];
	        }
	        int x = sum/n;
	        System.out.println(x+1);
	    
	     }
	    }

	    public  static void comDivFn(){
	        //fn for finding common diviser between two no.
	        long a = s.nextLong();
	        long b = s.nextLong();
	        long gcd;
	        long cntr =0;

	        if(a<b)
	        gcd = gcdFn(a, b);
	        else
	        gcd = gcdFn(b, a);
	        
	       
	        //divisers will be in pair like for 12: 3,4; 2,6,1,12 ; 
	        //1 more case where divisers are equal 16: 4,4, 2,8, 1, 16
	        for(long i =1;i<=Math.sqrt(gcd);i++){
	            if(gcd%i==0){
	                //if divisers are equal 
	                if(gcd/i==i)
	                 cntr++;
	                else //when divisers unequal gcd/i and i both different 
	                 cntr += 2;
	            }
	        }
	        //print total divisers
	        System.out.println(cntr);
	    }
	    
	    public static long gcdFn(long a, long b){
	        if(a==0) return b;

	        return gcdFn(b%a, a);
	    }


}
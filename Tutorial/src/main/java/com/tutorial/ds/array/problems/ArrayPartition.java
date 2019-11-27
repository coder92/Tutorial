package com.tutorial.ds.array.problems;

import java.math.BigInteger;
import java.util.Scanner;

public class ArrayPartition {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		long[] A = new long[n];
		
		BigInteger[] bigIntegers = new BigInteger[n];
		
		BigInteger mt = new BigInteger(Long.toString(1));
		
		for(int i=0;i<n;i++)
		{
			A[i] = scanner.nextLong();
			mt = mt.multiply(new BigInteger(Long.toString(A[i])));
		}
		
		BigInteger m = new BigInteger(Long.toString(1));
		
		BigInteger mn = new BigInteger(Long.MAX_VALUE+"");
		
		int mx =0;
		
		BigInteger temp;
		
		for(int x =0;x<n;x++)
		{
			m = m.multiply(new BigInteger(Long.toString(A[x])));
			mt = mt.divide(new BigInteger(Long.toString(A[x])));
			temp = m.subtract(mt).abs();
			
			if(temp.compareTo(mn) ==-1)
			{
				mn = temp;
				mx = x;
			}
		}
		
		System.out.println(mx);
		
		
	}
	
	
	
	
}

package com.tutorial.ds.dp;

public class FibonacciSeriesDemo {
	

	static int[] fib;
    public static void main(String args[] ) throws Exception 
    {
    	System.out.println(fibonacci(3));
    }
    
    
    
    static int fibonacci(int n)
    {
    	if(n==0 || n==1) return n;
    	
        if(fib[n]!=-1)
            return fib[n];
        
        fib[n]=(fibonacci(n-1)+fibonacci(n-2));
        
        return fib[n];
    }
    
    static int fibonacci1(int n)
    {
    	if(n==0 || n==1) return n;
    	
        return (fibonacci(n-1)+fibonacci(n-2));
    }
    
    static int fibonacci2(int n)
    {
    	if(n==0 || n==1) return n;
    	
    	int a=0, b=1, temp;
    	for(int i=2;i<=n;i++)
    	{
    		temp = b;
    		b = a+b;
    		a = temp;
    	}
    	return b;
    }

}

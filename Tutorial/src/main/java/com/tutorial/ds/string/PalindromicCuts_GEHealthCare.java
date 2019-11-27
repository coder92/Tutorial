package com.tutorial.ds.string;

import java.util.Scanner;

public class PalindromicCuts_GEHealthCare {

//	static int sum=0;
	public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int n, k;
        //n = s.nextInt();
       // k = s.nextInt();
        n=5;
        k=2;
        
       // String str = s.nextLine();                 // Reading input from STDIN
        //str = aabbc
        String str ="aabbc";
       // System.out.println(isPalindrome("abbb"));
      //  System.out.println(allPalindromicCuts(str, n, k+1));
      //  System.out.println(subStringSlicing("abbavv"));
        int t=2;
        while(t-->0){
            if(subStringSlicing(s.nextLine())){
                System.out.println("YES");
            }else{
                 System.out.println("NO");
            }
        }

    }
    
    public static int allPalindromicCuts(String str, int n, int k){
        int sum=0;
        int nc = ncr(n-1,k);
    	for(int i=0;i<nc;i++) {
    		for(int j=0;j<k;j++) {
    			if(isPalindrome(str.substring(i+j,i+j+1))){
    				sum++;
    			}
    		}
    	}
    	
    	return sum;
    	
 
       /* if(k==1) {
        	System.out.println("str="+str+", n="+n+", k="+k);
        	if(isPalindrome(str)) {
        		return 1;
        	}
        	return 0;
        }
        
        for(int i=1;i<=n-1;i++) {
        	System.out.println("i="+i);
        	System.out.println("str="+str);
        	System.out.println(">>before:allPalindromicCuts(str.substring(0, i), i, 1)");
        	System.out.println(">>42>>sum="+sum);
        	sum += allPalindromicCuts(str.substring(0, i), i, 1);
        	System.out.println(">>44>>sum="+sum);
        	//System.out.println(">>after:allPalindromicCuts(str.substring(0, i), i, 1)");
        	sum += allPalindromicCuts(str.substring(i), n-i, k-1);
        	System.out.println(">>47>>sum="+sum);
        	//System.out.println(">>after:sum =+ allPalindromicCuts(str.substring(i), n-i, k-1);");
        }
        System.out.println(">>sum="+sum);
    	return sum;*/
    }
    
    
    public static int ncr(int n, int r) {
    	int x;
    	x = fact(n)/(fact(n-r)*fact(r));
    	return x;
    }
    
    public static int fact(int n) {
    	int a=1;
    	int b=1;
    	int f = 1;
    	for(int i=2;i<=n;i++) {
    		f= i*b;
    		a=b;
    		b=f;
    	}
    	return f;
    }
    
    public static boolean isPalindrome(String str){
    	System.out.println(">>isPalindrome:Str="+str);
    	int len = str.length();
    	if(len==1) {
    		return true;
    	}
    
    	System.out.println("len="+len);
    	int l=0;
    	int h=len-1;
    	for(int i=0;i<len/2;i++) {
    		if(str.charAt(l)!=str.charAt(h)) {
    			System.out.println("l="+l+", h="+h);
    			return false;
    		}
    		l++;
			h--;
    	}
       return true;
    }
    
    
    public static boolean subStringSlicing(String str) {
    	int l= str.length();
    	for(int i=0;i<l;i++) {
    		String str1= str.substring(0,i+1);
    		String str2 = str.substring(i+1);
    		System.out.println("str1="+str1);
    		System.out.println("str2="+str2);
    		if(isPalindrome(str2+str1)) {
    			System.out.println(">>true");
    			return true;
    		}
    	}
    	return false;
    }

}

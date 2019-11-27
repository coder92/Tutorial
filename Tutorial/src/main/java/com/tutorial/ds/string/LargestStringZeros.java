package com.tutorial.ds.string;

import java.util.Random;

public class LargestStringZeros {

	public static void main(String[] args) {
		
		
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		int len = r.nextInt(10);
		for(int i=0;i<len;i++) {
			sb.append(""+r.nextInt(10)%2);
		}
		int n= LSSZ(sb.toString(),len);
		
		
		
		System.out.println(n);
	}
	
	
	
	private static int LSSZ(String s, int len) {
		
		int i = s.indexOf("00");
		int l=0;
		if(i>=0) {
			l = LESS(s.substring(0,i))+LESS(s.substring(i+2));
		}
		
		return l;
	}



	private static int LESS(String s) {
		System.out.println(s);
		if(s.length()==0) return 0;
		
		int l=0;
		
		//max string with equal no of zeros and 1
		int cs=0,cst=0,cen=0,cl=0;
		int ml=0,mst=0,men=0;
		boolean f=false;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='0') {
				cs++;
			}
			else {
				cs--;
			}
			
			if(cs>0) {
				f=true;
				cen++;
				cl++;
			}else {
				
			}
		}
		
		
		
		return l;
	}

	private static int LSS(String s, int len) {
		System.out.println(s);
		int i=0,j;
		int cs=0;
		int ms=0,ms_en=0,ms_st=0;
		int st=0,en=0;
		
		int ml=0,cl=0;
		
		for(j=0;j<len;j++) {
			if(s.charAt(j)=='0') {
				cs++;
			}else {
				cs--;
			}
			
			if(cs>0) {
				en++;
				cl++;
			}else {
				
				//cs=0;
				//cl = en-st;
				if(ml<cl) {
					ms_st=st;
					ms_en=en;
					ml=cl;
				}
				if(j<len-1)
				st=j+1;
				else st=j;
				
				en=st;
			}
			
			//System.out.println("st="+st+" en="+en+" cl="+cl);
			//System.out.println("ms_st="+ms_st+" ms_en="+ms_en+" ml="+ml);
			
			
		}
		
		cl = en-st;
		if(ml<cl) {
			ms_st=st;
			ms_en=en;
			ml=cl;
		}	
		//System.out.println("st="+st+" en="+en+" cl="+cl);
		System.out.println("ms_st="+ms_st+" ms_en="+ms_en+" ml="+ml);
		
		
		return ml;
	}

}

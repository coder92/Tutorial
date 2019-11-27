package com.tutorial.ds.dp;

//https://practice.geeksforgeeks.org/problems/longest-common-substring/0
public class LCS {
	
	static String X, Y;
	
	public static void main(String[] args) {
		X="QHNWNKUEWHSQMGBBUQCLJJIVSWMDKQTBXIXMVTRRBLJPTNSNFWZQFJMAFADRRWSOFSBCNUVQHFFBSAQXWPQCAC";
		Y="LRBBMQBHCDARZOWKKYHIDDQSCDXRJMOWFRXSJYBLDBEFSARCBYNECDYGGXXPKLORELLNMPAPQFWKHOPKMCO";
		System.out.println(lcsRec(X.length(),Y.length(), 0));
		System.out.println(lcsDP(X.length(),Y.length()));
	}
	
	public static int lcsRec(int i, int j, int count) {
		
		if(i==0 || j==0)
			return count;
		
		if(X.charAt(i-1)==Y.charAt(j-1)) {
			count = lcsRec(i-1,j-1,count+1);
		}else {
			count = Math.max(count, Math.max(lcsRec(i,j-1,0), lcsRec(i-1,j,0)));
		}
		
		
		return count;
	}
	
	public static int lcsDP(int n, int m) {
		int[][] mat = new int[n][m];
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(X.charAt(i)==Y.charAt(j)) {
					if(i==0 || j==0)
						mat[i][j]=1;
					else
						mat[i][j] =  mat[i-1][j-1]+1;
				}else {
					if(i==0 || j==0)
						mat[i][j]=0;
					else
						mat[i][j]=Math.max(mat[i][j-1], mat[i-1][j]);
					
				}
			}
		}
		
		
		return mat[n-1][m-1];
	}
}

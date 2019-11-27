package com.tutorial.ds.grid;

import com.tutorial.common.CommonClass;

//https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
public class Rotate90Degree {
	public static void main(String[] args) {
		int n=3;
		int m=3;
		int[][] grid = new int[n][m];
		int k=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				grid[i][j] = k++;
			}
		}
		System.out.println();
		CommonClass.printGrid(grid, n, m);
		
		Rotate90Degree obj = new Rotate90Degree();
		
		obj.rotate90Deg(grid, n, m);
		
		System.out.println();
		CommonClass.printGrid(grid, n, m);
		
		
	}
	
	public void rotate90Deg(int[][] grid, int n, int m) {
			
	}
}

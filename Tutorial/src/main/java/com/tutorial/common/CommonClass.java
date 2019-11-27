package com.tutorial.common;

public class CommonClass {
	
	public static void printArray(int[] A) {
		System.out.println();
		System.out.print("Index:| ");
		for(int i=0;i<A.length;i++) {
			System.out.print(i+" | ");
		}
		System.out.print("\nArray:| ");
		for(int i:A) {
			System.out.print(i+" | ");
		}
		System.out.println();
	}
	
	public static void printGrid(int[][] grid, int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void printMessage(String msg) {
		System.out.println("\n========== "+msg+" ==========");
	}
}

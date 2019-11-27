package com.tutorial.ds.sorting;

import com.tutorial.common.CommonClass;
import com.tutorial.ds.tree.BST;
import com.tutorial.ds.tree.BinaryTreeNode;
import com.tutorial.java.io.exception.TreeSortException;

import java.util.ArrayList;

/**
 * <p>
 * Tree sort is a sorting algorithm that is based on Binary Search Tree data structure. 
 * It first creates a binary search tree from the elements of the input list or array and then 
 * performs an in-order traversal on the created binary search tree to get the elements in sorted order.
 * </p>
 * 
 * <br>
 * 
 * <code>
 *  Step 1:Take the elements input in an array.
	Step 2: Create a Binary search tree by inserting data items from the array into the
        binary search tree.
	Step 3: Perform in-order traversal on the tree to get the elements in sorted order.
 * </code>
 * 
 * 
 * @author Ankit.Dixit
 *
 */
public class TreeSort {
	public static void main(String[] args) {
		demoTreeSort();
	}

	private static void demoTreeSort() {
		
		//create input 
		int[] A = {2,3,4,1,1,5,6,7,3,65,32,3354};
		//sort
		treeSort(A);
		
	}

	private static void treeSort(int[] A) {
		try {
			BST bst = new BST();
			//create BST
			BinaryTreeNode root = bst.createBST(A);
			CommonClass.printMessage("Array Before Sorting");
			CommonClass.printArray(A);
			//In-Order Traversal 
			ArrayList<Integer> sortedArray = new ArrayList<Integer>();
			bst.inOrderTraversal(root, sortedArray);
			System.out.println();
			System.out.println(sortedArray);
			//CommonClass.printArray(A);
		
		}catch(TreeSortException tse) {
			tse.printStackTrace();
			tse.getMessage();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
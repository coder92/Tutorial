package com.tutorial.ds.tree;

import com.tutorial.java.io.exception.TreeSortException;

import java.util.ArrayList;

/**
 * <h1>Binary search tree </h1>
 * <p>
 * <parent | parent| >=parent
 * </p>
 * <p>
 * Traversal -> Depth First Traversal, Breath First Traversal( Inorder, 
 * 
 * </p>
 * @author Ankit.Dixit
 *
 */
public class BST {

	/**
	 * Create BST with Array 
	 * @param A: input
	 * @return TreeNode : rootNode
	 * @throws Exception
	 */
	public BinaryTreeNode createBST(int[] A) throws Exception {

		if(A.length==0)
			throw new TreeSortException("Array is empty");

		BinaryTreeNode root=new BinaryTreeNode(A[0]);


		//insert elements in BST
		for(int i=1;i<A.length;i++) {
			insert(A[i],root);
		}

		return root;
	}

	/**
	 * <p> 
	 * inserting an element in the tree. if data < parent => insert in left subtree or data >= parent => data will be insert in the right subtree.   
	 * </p>
	 * @param data: element's data
	 * @param root: root Node
	 * @return : Node : rootNode
	 */
	private BinaryTreeNode insert(int data, BinaryTreeNode root) {
		if(root==null) {
			root = new BinaryTreeNode(data);
			return root;
		}
		if(data < root.getData() ) {
			root.setLeft(insert(data,root.getLeft())); 
		}else {
			root.setRight(insert(data, root.getRight()));
		}
		return root;
	}

	/**
	 * <p> InOrder Traversal : Left ->Node->Right</p>
	 * @param root
	 * @param sortedArray
	 */
	public void inOrderTraversal(BinaryTreeNode root, ArrayList<Integer> sortedArray) {
		if(root.getLeft() !=null)
			inOrderTraversal(root.getLeft(),sortedArray);
		//System.out.print(root.getData()+" | ");
		sortedArray.add(root.getData());
		if(root.getRight()!=null)
			inOrderTraversal(root.getRight(), sortedArray);
	}
}


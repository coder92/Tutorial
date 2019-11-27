package com.tutorial.ds.tree;

/**
 * 
 * <h1>Generic TreeNode </h1>
 * <p>Two possible structure </p> 
 * <p>first link from parent to all children </p>
 * <p>Second link from parent to first children and then all sibling are connected in horizontal line.</p>
 * <p>Since we are able to convert any generic tree to binary representation; in practice we use binary trees. 
 * We can treat all generic trees with a first child/next sibling representation as binary trees.</p>
 * @author Ankit.Dixit
 *
 */
public class GenericTreeNode {
	int data;
	GenericTreeNode firstChild;
	GenericTreeNode nexrSibling;
	
	public GenericTreeNode(int data) {
		this.data=data;
		this.firstChild=null;
		this.nexrSibling=null;
	}
}
package com.tutorial.ds.tree;

/**
 * <h1> ThreadedBinaryTree </h1>
 * <p> 
 * The Inorder traversal of a Binary tree can either be done using recursion or with the use of an auxiliary stack.<br> 
 * Threaded Binary Trees are used to make the inorder traversal faster and do it without stack and without recursion. <br>
 * A binary tree is made threaded by making all right child pointers that would normally be NULL point to the inorder successor of the node (if it exists).</p>
 * <p>
 * There are two types of threaded binary trees:<br>
 * Single Threaded: Where a NULL right pointers is made to point to the inorder successor (if successor exists).<br>
 * Double Threaded: Where both left and right NULL pointers are made to point to inorder predecessor and inorder successor respectively. The predecessor threads are useful for reverse inorder traversal and postorder traversal.
 * </p>
 * <p>Implement using inorder traversal </p>
 * <p> </p>
 * <p> </p>
 * <br>
 * @see https://practice.geeksforgeeks.org/tracks/PC-W6-T/?batchId=140#collapse9
 * @author Ankit.Dixit
 * 
 */
public class ThreadedBinaryTree {
	
	public Node createThreadedBinaryTree() {
		Node root = new Node();
		return root;
	}
	
	public Node createThreadedBinaryTree(String inputLine) {
		Node root = new Node();
		
		String[] inputs = inputLine.split(" ");
		
		for(int i=0;i<inputs.length;i +=3) {
			insert(root, inputs[i], inputs[i+1], inputs[i+2]);
		} 
		
		return root;
	}
	
	public void insert(Node root, String pNodeData, String cNodeData, String childPreference) {

		try {
			int pData = Integer.parseInt(pNodeData);
			int cData = Integer.parseInt(cNodeData);
			char chr = childPreference.charAt(0);
			
			Node pNode = search(root, pData);
			
			if(pNode==null) {
				if(root==null || root.data==-1) 
					root = new Node(pData);
					
				pNode = root;
			}
			
			Node cNode = new Node(cData);
			
			if(chr=='L')
				pNode.left=cNode;
			else
				pNode.right = cNode;
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void inOrderTraversal(Node root) {
		
	}
	
	public Node search(Node root, int data) {
		return null;
	}
	
	
	public static void main(String[] args) {
		
	}
	
	class Node {
		int data;
		Node left, right;
		boolean rightThread;
		
		public Node() {
			data=-1;
			left=right=null;
			rightThread = false;
		}
		
		public Node(int data) {
			this.data = data;
			left=right =null;
			rightThread = false;
		}
	}

}

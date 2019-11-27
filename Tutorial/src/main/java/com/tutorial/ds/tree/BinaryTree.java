package com.tutorial.ds.tree;

import com.tutorial.common.CommonClass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	private BinaryTreeNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * <p>Will create tree;</p>
	 * @param inputLine: 0 1 L 0 2 R 1 3 L 1 4 R 2 5 L 2 6 R 3 7 L 3 8 R 4 9 L 4 10 R 5 11 L 5 12 R 6 13 L 6 14 R
	 * @return rootNote
	 */
	public BinaryTreeNode createTree(String inputLine) {
		
		String[] inputs = inputLine.split(" ");
		
		for(int i=0;i<inputs.length;i +=3) {
			insert(inputs[i], inputs[i+1], inputs[i+2]);
		}
		
		return root;
	}
	
	/**
	 * Insert node at appropriate place
	 * @param pNodeData
	 * @param cNodeData
	 * @param childPreference
	 */
	public void insert(String pNodeData, String cNodeData , String childPreference ) {
		try {
			int pData = Integer.parseInt(pNodeData);
			int cData = Integer.parseInt(cNodeData);
			char chr = childPreference.charAt(0);
			
			BinaryTreeNode pNode = search(pData);
			
			if(pNode==null) {
				root = new BinaryTreeNode(pData);	
				pNode = root;
			}
			
			BinaryTreeNode cNode = new BinaryTreeNode(cData);
			
			if(chr=='L')
				pNode.setLeft(cNode);
			else
				pNode.setRight(cNode);
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private BinaryTreeNode search(int pData) {
		return searchInOrder(root, pData);
	}

	/**
	 * <h1>Search</h1>
	 * <p>implement using inorder traversal </p>
	 * <p></p>
	 * @param cNode : current Node
	 * @param pData : data of the node to be searched
	 * @return : node with given data or null if no node matched.
	 */
	public BinaryTreeNode searchInOrder(BinaryTreeNode cNode, int pData) {
		
		if(cNode==null)
			return null;
		
		BinaryTreeNode rNode;
		
		rNode = searchInOrder(cNode.getLeft(), pData);
		if(rNode!=null)
			return rNode;
		
		if(cNode.getData()==pData)
			return cNode;
		
		rNode = searchInOrder(cNode.getRight(), pData);
		
		if(rNode!=null)
			return rNode;
		
		return null;
	}

	
	public void delete(int data) {
		
	}
	
	/**
	 * <h1>InOrder Traversal Without Recursion</h1>
	 * <p>Recursive : Time Complexity: O(n). Space Complexity: O(n). </p>
	 * <h2>Pseudo code</h2>
		1.preOrderTraversalWithRecursion(node.getLeft());<br>
		2.print(node.data); <br>
		3.preOrderTraversalWithRecursion(node.getRight());<br>
	 * 
	 * 
	 * @param node : root node
	 */
	public void inOrderTraversalWithRecursion(BinaryTreeNode node) {
		if(node==null)
			return;
		
		inOrderTraversalWithRecursion(node.getLeft());
		System.out.print(node.getData()+" ");
		inOrderTraversalWithRecursion(node.getRight());
	}
	
	/**
	 * <h1>PreOrder Traversal without recursion</h1>
	 * <p>Time Complexity: O(n). Space Complexity: O(n). </p>
	 * <h2>Pseudo code</h2>
	 * 1.create a stack <br>
	 * 2.while(true)<br>
	 * 3.while(root!=null)<br>
	 * 4.push the current node in stack <br>
	 * 5.root = root.left;<br>
	 * 6.End 2nd while loop<br>
	 * 7. if(stack is empty) then break;<br>
	 * 8.root = stack.pop();<br>
	 * 9.print current node<br>
	 * 10.root = root.right;<br>
	 * 11. End 1st While loop<br>
	 * 
	 * @param node : root node
	 */
	public void inOrderTraversalWithoutRecursion(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode root = node;
		while(true) {
			while(root!=null) {
				
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			
			System.out.print(root.getData()+" ");
			
			root= root.getRight();
		}
		
	}
	
	/**
	 * <h1>PreOrder Traversal Without Recursion</h1>
	 * <p>Recursive : Time Complexity: O(n). Space Complexity: O(n). </p>
	 * <h2>Pseudo code</h2>
	 * 	1.print(node.data); <br>
		2.preOrderTraversalWithRecursion(node.getLeft());<br>
		3.preOrderTraversalWithRecursion(node.getRight());<br>
	 * 
	 * 
	 * @param node : root node
	 */
	public void preOrderTraversalWithRecursion(BinaryTreeNode node) {
		if(node==null)
			return;
		
		System.out.print(node.getData()+" ");
		preOrderTraversalWithRecursion(node.getLeft());
		preOrderTraversalWithRecursion(node.getRight());
	}
	
	/**
	 * <h1>PreOrder Traversal without recursion</h1>
	 * <p>Time Complexity: O(n). Space Complexity: O(n). </p>
	 * <h2>Pseudo code</h2>
	 * 1.create a stack <br>
	 * 2.while(true)<br>
	 * 3.while(root!=null)<br>
	 * 4.print current node<br>
	 * 5.push the current node in stack <br>
	 * 6.root = root.left;<br>
	 * 7.End 2nd while loop<br>
	 * 8. if(stack is empty) then break;<br>
	 * 9.root = stack.pop();<br>
	 * 10.root = root.right;<br>
	 * 11. End 1st While loop<br>
	 * 
	 * @param node : root node
	 */
	public void preOrderTraversalWithoutRecursion(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode root = node;
		while(true) {
			while(root!=null) {
				System.out.print(root.getData()+" ");
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			
			root= root.getRight();
		}
		
	}
	
	/**
	 * <h1>Post Order Traversal With Recursion</h1>
	 * <p>Time Complexity: O(n). Space Complexity: O(n). </p>
	 * <h2>Pseudo code</h2>
	 * 	1.print(node.data); <br>
		2.postOrderTraversal(node.getLeft());<br>
		3.inOrderTraversal(node.getRight());<br>
	 * 
	 * @param node : root node
	 */
	public void postOrderTraversalWithRecursion(BinaryTreeNode node) {
		if(node==null)
			return;
		
		postOrderTraversalWithRecursion(node.getLeft());
		postOrderTraversalWithRecursion(node.getRight());
		System.out.print(node.getData()+" ");
		
	}
	/**
	 * <h1>PostOrder Traversal without recursion</h1>
	 * <p>Time Complexity: O(n). Space Complexity: O(n). </p>
	 * 	
	 * 
	 * @param node : root node
	 */
	public void postOrderTraversalWithoutRecursion(BinaryTreeNode node) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode root = node;
		BinaryTreeNode previous = null;
		while(true) {
			while(root!=null) {
				stack.push(root);
				root = root.getLeft();
			}
			
			while(root==null && !stack.isEmpty()) {
				root = stack.peek();
				
				if(root.getRight()==null || root.getRight() ==previous) {
					System.out.print(root.getData()+" ");
					stack.pop();
					previous = root;
					root = null;
				}else {
					root = root.getRight();
				}
			}
			if(stack.isEmpty())
				break;
		}
		
	}
	
	/**
	 * <p>level order traversal using recursion</p>
	 * <p>Complexity - O(n^2) in worst case</p>
	 * @param node: root node
	 */
	public void levelOrderTraversalWithRecursion(BinaryTreeNode node) {
		 int h = height(node);
		 for(int i=1;i<=h;i++) {
			 printLevelOrderTraversal(node, i);
		 }
	}
	
	/**
	 * <p> return the height of the tree. using recursive approach.</p>
	 * <p> starting with 1. 1 height for root node.</p>
	 * <p>Time Complexity - O(n)</p>
	 * @param root 
	 * @return : height
	 */
	public int height(BinaryTreeNode root) {
		if(root==null)
			return 0;
		
		int lHeight = height(root.getLeft());
		int rHeight = height(root.getRight());
		
		return (lHeight>rHeight)?lHeight+1:rHeight+1;
	}
	
	public void printLevelOrderTraversal(BinaryTreeNode root, int level) {
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.getData()+" ");
		else if(level>1) {
			printLevelOrderTraversal(root.getLeft(), level-1);
			printLevelOrderTraversal(root.getRight(), level-1);
		}
		
	}
	
	/**
	 * <p>Level Order Traversal without using recursion</p>
	 * <p>O(n)</p>
	 * <p>Using Queue</p>
	 * @param node
	 */
	public void levelOrderTraversalWithoutRecursion(BinaryTreeNode node) {
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(node);
		
		BinaryTreeNode tNode;
		
		while(!queue.isEmpty()) {
			tNode = queue.poll();
			if(tNode!=null) {
				System.out.print(tNode.getData()+" ");
				queue.add(tNode.getLeft());
				queue.add(tNode.getRight());
			}
		}
	}
	
	/**
	 * <h1>findMaxElementWithRecursion</h1>
	 * <h2>Pseudo Code </h2>
	 * find max in left sub tree <br>
	 * find max in right sub tree<br> 
	 * return max(leftMax, rightMax, rootData);<br>
	 * @param node : rootNode 
	 * @return maxElement's data
	 */
	public int findMaxWithRecursion(BinaryTreeNode node) {
		
		int max= Integer.MIN_VALUE;
		
		if(node!=null) {
			
			int leftMax = findMaxWithRecursion(node.getLeft());
			int rightMax = findMaxWithRecursion(node.getRight());
			
			if(leftMax > rightMax) {
				if(leftMax >node.getData())
					max = leftMax;
				else
					max = node.getData();
			}else {
				if(rightMax>node.getData()) {
					max = rightMax;
				}else {
					max = node.getData();
				}
			}
		}
		return max;
	}
	
	/**
	 * <h1>findMaxElementWithRecursion</h1>
	 * <h2>Pseudo Code </h2>
	 * level order traversal and find max;
	 * @param node : rootNode 
	 * @return maxElement's data
	 */
	public int findMaxWithoutRecursion(BinaryTreeNode node) {
		int max = Integer.MIN_VALUE;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(node);
		BinaryTreeNode tNode;
		while(!queue.isEmpty()) {
			tNode = queue.poll();
			if(tNode!=null) {
				if(tNode.getData() > max) {
					max = tNode.getData();
				}
				
				queue.add(tNode.getLeft());
				queue.add(tNode.getRight());
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		String inputLine = "0 1 L 0 2 R 1 3 L 1 4 R 2 5 L 2 6 R 3 7 L 3 8 R 4 9 L 4 10 R 5 11 L 5 12 R 6 13 L 6 14 R";
		
		long startTime, endTime;
		
		startTime = System.nanoTime();
		BinaryTreeNode node = bt.createTree(inputLine);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in creating the tree is :"+(endTime-startTime));
		
		CommonClass.printMessage("InOrder Traversal With Recursion");
		startTime = System.nanoTime();
		bt.inOrderTraversalWithRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in InOrderTraversal is :"+(endTime-startTime));
		
		CommonClass.printMessage("InOrder Traversal without Recursion");
		startTime = System.nanoTime();
		bt.inOrderTraversalWithoutRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in InOrderTraversal is :"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("PreOrder Traversal With Recursion");
		startTime = System.nanoTime();
		bt.preOrderTraversalWithRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in PreOrderTraversal is :"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("PreOrder Traversal Without Recursion");
		startTime = System.nanoTime();
		bt.preOrderTraversalWithoutRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in PreOrderTraversal is :"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("PostOrder Traversal With Recursion");
		startTime = System.nanoTime();
		bt.postOrderTraversalWithRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in PostOrderTraversal is :"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("PostOrder Traversal Without Recursion");
		startTime = System.nanoTime();
		bt.postOrderTraversalWithoutRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in PostOrderTraversal is :"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("Level Order Traversal Using Recursion");
		startTime = System.nanoTime();
		bt.levelOrderTraversalWithRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in LevelOrderTraversalWithRecusion is :"+(endTime-startTime));
		
		
		System.out.println();
		CommonClass.printMessage("Level Order Traversal without using recursion");
		startTime = System.nanoTime();
		bt.levelOrderTraversalWithoutRecursion(node);
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in LevelOrderTraversalWithoutRecusion is :"+(endTime-startTime));
		
		
		System.out.println();
		CommonClass.printMessage("Find Max Using Recursion");
		startTime = System.nanoTime();
		System.out.println(bt.findMaxWithRecursion(node));
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in Find Max Using Recursion is :"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("Find Max without Using Recursion");
		startTime = System.nanoTime();
		System.out.println(bt.findMaxWithoutRecursion(node));
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in Find Max without Using Recursion is (ns):"+(endTime-startTime));
		
		System.out.println();
		CommonClass.printMessage("Search Using Recursion");
		startTime = System.nanoTime();
		System.out.println(bt.searchInOrder(node, 78));
		endTime = System.nanoTime();
		CommonClass.printMessage("Time taken in Search Using Recursion is (ns):"+(endTime-startTime));
		
		
	}

}

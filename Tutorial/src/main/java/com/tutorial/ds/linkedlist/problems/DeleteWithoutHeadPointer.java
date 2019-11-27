package com.tutorial.ds.linkedlist.problems;

/**
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * @author Ankit.Dixit
 *
 */
public class DeleteWithoutHeadPointer {
	public static void main(String[] args) {
		
	}
	void deleteNode(Node node)
	{
	     Node prevNode = null;
	     Node nextNode = node;
	     
	     while(nextNode.next !=null){
	         prevNode = nextNode;
	         nextNode = nextNode.next;
	         prevNode.data = nextNode.data;
	     }
	     prevNode.next = null;
	}
	
	
}

class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}



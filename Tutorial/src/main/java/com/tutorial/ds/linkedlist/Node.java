package com.tutorial.ds.linkedlist;

public class Node {
	
	private Object data;
	private Node prevNode;
	private Node nextNode;
	
	public Node() {
		this.prevNode=null;
		this.nextNode=null;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}

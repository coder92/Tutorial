package com.tutorial.ds.linkedlist;

public class SimpleLinkedList implements LinkedList {

	int size=0;
	Node headNode=null;


	@Override
	public void addFirst(Object data) {
		Node newNode = new Node();
		newNode.setData(data);
		if(headNode==null) {
			headNode = newNode;
		}else {
			newNode.setNextNode(headNode);
			headNode = newNode;
		}
		size++;
	}


	@Override
	public void addLast(Object data) {
		if(headNode==null) {
			headNode.setData(data);
		}else {
			Node newNode = new Node();
			newNode.setData(data);
			traverse(size).setNextNode(newNode);
		}
		size++;
	}


	@Override
	public void delete(int position) {
		if(position==1) {
			headNode=headNode.getNextNode();
			size--;
		}else if(position<=size && position>1) {
			Node node = traverse(position-1);
			node.setNextNode(node.getNextNode().getNextNode());
			size--;
		}else {
			System.out.println("pls enter valid position");
		}
	}


	@Override
	public int indexOf(Object data) {
		int cur_pos=1;
		Node node = headNode;
		
		while(cur_pos++<=size) {
			if(node.getData()==data) {
				return cur_pos;
			}
			node = node.getNextNode();
		}
		return -1;
	}


	@Override
	public void display() {
		
		Node node = headNode;
		
		if(node==null) {
			System.out.println("list is empty");
		}else if(node.getNextNode()==null) {
			System.out.println("->"+node.getData());
		}else {
			while(node.getNextNode()!=null) {
				System.out.print("->"+node.getData());
				node = node.getNextNode();
			}
			System.out.println("->"+node.getData());
		}
	}

	
	private Node traverse(int final_pos) {
		int cur_pos=1;
		Node node = headNode;
		
		if(final_pos<1) return null;
		
		while(cur_pos++<final_pos) {
			node = node.getNextNode();
		}
		return node;
	}


	@Override
	public int size() {
		return size;
	}
	
	
}

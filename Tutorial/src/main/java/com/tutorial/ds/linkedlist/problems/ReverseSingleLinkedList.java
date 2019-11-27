package com.tutorial.ds.linkedlist.problems;

public class ReverseSingleLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		head.next=n1;
		
		Node n2 = new Node (3);
		
		n1.next=n2;
		
		Node n3 = new Node(4);
		
		n2.next=n3;
		
		System.out.println("Before Reverse the LL");
		printLinkedList(head);
		
		head = reverseLinkedList(head);
		
		System.out.println("After Revering the Linked List");
		printLinkedList(head);
		
	}

	/**
	 * Use three pointer : prev, curr, next
	 * @param head
	 */
	private static Node reverseLinkedList(Node head) {
		Node pNode=null, cNode, nNode;
		
		cNode = head;
		
		while(cNode!=null) {
			nNode = cNode.next;
			cNode.next=pNode;
			pNode = cNode;
			cNode=nNode;
			
		}
		return pNode;
	}

	private static void printLinkedList(Node head) {
		Node tNode = head;
		
		while(tNode!=null) {
			System.out.print(tNode.data+"->");
			tNode = tNode.next;
		}
		System.out.println("null");
	}

}



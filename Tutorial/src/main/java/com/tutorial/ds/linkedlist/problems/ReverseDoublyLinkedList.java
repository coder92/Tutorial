package com.tutorial.ds.linkedlist.problems;

//https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
public class ReverseDoublyLinkedList {
	
	Node reverse(Node head)
    {
        Node cNode = head;
        Node nNode ;
        Node pNode;
        
        while(true){
            nNode = cNode.next;
            pNode = cNode.prev;
            cNode.next = pNode;
            cNode.prev = nNode;
            
            if(nNode ==null)
                break;
            cNode = nNode;
            
        }
        head = cNode;
        return head;
    }
	
	class Node{
		int data;
		Node prev;
		Node next;
	}
}

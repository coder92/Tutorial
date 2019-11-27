package com.tutorial.ds.linkedlist.problems;

import java.util.Stack;

public class PallindromeChecking {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node cNode = head;
		for(int i=2;i<10;i++) {
			Node temp = new Node(i);
			cNode.next = temp;
			cNode = cNode.next;
		}
		PallindromeChecking obj = new PallindromeChecking();
		System.out.println(obj.isPalindrome(head));
	}
	
	boolean isPalindrome(Node head) 
    {
        Node temp = head;
        Node middleNode = head;
        
        while(temp!=null  && temp.next!=null){
           // System.out.println(temp.data);
        //    System.out.println(middleNode.data);
            temp = temp.next.next;
            middleNode = middleNode.next;
          //  System.out.println(temp.data);
        //    System.out.println(middleNode.data);
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        Node tmn;
       
        if(temp==null)
            tmn = middleNode;
        else
            tmn = middleNode.next;
        
        
        while(tmn!=null){
            stack.push(tmn.data);
            tmn = tmn.next;
        }
        
        //System.out.println(stack);
        
        temp = head;
        while(!stack.isEmpty()){
            //System.out.println(temp.data);
            if(temp.data!=stack.pop()){
                return false;
            }
            temp = temp.next;
        }
        
        return true;
    }   
}

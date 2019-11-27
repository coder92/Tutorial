package com.tutorial.ds.misc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class GiftVoucher {

	public static void main(String[] args) {
		
		int n,m,k;
		int x, y;
		
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		k = scanner.nextInt();
		
		//testing 
		
		HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
		
		//LinkedList<Integer> list = new LinkedList<>();
		
		
		while(m-->0) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			
			if(!hashMap.containsKey(x)) {
				if(!hashMap.containsKey(y)) {//00
					int temp;
					if(y<x) {
						temp = y;
						y = x;
						x = temp;
					}
					LinkedList<Integer> list = new LinkedList<Integer>();
					list.add(x);
					list.add(y);
					hashMap.put(x, list);
		
					hashMap.put(y, x);
					//TODO
					//System.out.println(hashMap);
				}else {//01   //5 4
					Object value = hashMap.get(y);
					if(value instanceof Integer) {
						Object object = hashMap.get(value);
						if(object instanceof LinkedList) {
							((LinkedList) object).add(x);
							hashMap.put(x, value);
						}else {
							//System.out.println("error"); //TODO
						}
					}else { //5 1
						LinkedList listObj = (LinkedList) hashMap.get(y);
						listObj.add(x);
						hashMap.put(x, y);
					}
					//TODO
					//System.out.println(hashMap);
				}
			}else {
				if(!hashMap.containsKey(y)) {//10           
					Object value = hashMap.get(x);
					if(value instanceof Integer) { //5 8
						int root = ((Integer) value).intValue();
						LinkedList list =  (LinkedList) hashMap.get(root);
						list.add(y);
						hashMap.put(y, root);
					}else { //1 8
						LinkedList list =  (LinkedList) value;
						list.add(y);
						hashMap.put(y, x);
					}
					
				}else {//11    //4 6   //3 1  //6 1 //3 4
					
					Object root1 = hashMap.get(x);
					Object root2 = hashMap.get(y);
					
					if(root1 instanceof Integer) {
						if(root2 instanceof Integer) {//4 5 } 1
							if(((Integer)root1).intValue()==((Integer)root2).intValue()) {
								//do nothing
							}else {//4 6} 1 3
								LinkedList list1 = (LinkedList) hashMap.get(root1);
								LinkedList list2 = (LinkedList) hashMap.get(root2);
								list1.addAll(list2);
								hashMap.put((Integer) root2, root1);
								hashMap.put(y, root1);
							}
							
						}else { //6 1 //6 3 //4 3 //4 1
							if(((Integer) root1).intValue() == y) {
								
							}else {
								
							}
							
						}
					}else {
						if(root2 instanceof Integer) {//3 4
							
						}else { //3 1
							
						}
					}
					
					
					
					
					
					
				}
				
			}
		}
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		
		for(Integer key: hashMap.keySet()) {
			Object object = hashMap.get(key);
			if(object instanceof LinkedList) {
				//System.out.println(object);
				LinkedList<Integer> list = (LinkedList<Integer>) object;
				list.sort(null);
				if(list.size()>=k)
				linkedList.add(list.get(k-1));
			}
		}
		System.out.println(linkedList.size());
		
		for(int i=0;i<linkedList.size();i++) {
			System.out.print(linkedList.get(i)+" ");
		}
	}

}



/*
Gift Vouchers
Company X , an air transport service provider decided to give gift vouchers to the passengers this festive season. 
But they cannot give the gift vouchers to everyone in the flight. So, they decided to give the vouchers 
to every K-th passenger in each of their flights.

Every passenger who is travelling has a unique Id. Now, the manager asked you to tell them how many gift vouchers 
will be required in total and who all will be getting the gift vouchers.

Neither you are provided with the exact data that how many flights will be there nor the Id's of the passengers 
that belong to a particular flight. 
Instead you are given  M connections represented by two passenger Id's  x and y that denote x and y belong
 to the same flight.

Now, every K-th passenger from each flight will get the gift voucher after ordering them in the increasing order of 
their Id's.

Input Format

The first line of the input contains three space-separated integers N, M, and K, the total number of passengers, 
the total number of connections and the number K as described in the above statement.
Then M lines follow, each line contains two space-separated integers  x and y denoting that x and y belong to
 the same flight.

Output Format

In the first line of the output print the total number of passengers getting the gift vouchers.
In the next line of the output print space-separated Id's of the passengers getting the gift vouchers 
in the increasing order.

Constraints



Sample Input
6 3 2
1 4
5 4
3 6
Sample Output
2
4 6
Explanation
 belong to the same flight, passenger with Id  will get the voucher.  belong to the same flight, 
 passenger with Id  will get the voucher.  belong to the same flight, no one will get the gift 
 voucher as there is only  passenger.

 */
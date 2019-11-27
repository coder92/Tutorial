package com.tutorial.ds.array.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FourElements {
	
	
	public static void main(String[] args) {

		   try{
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(new File("C:\\Users\\ankit\\Workspaces\\Tutorials\\Tutorial\\src\\main\\java\\com\\tutorial\\ds\\array\\problems\\FourElementsInputFile.txt"))));
		    
		   
		    int n;
		    int[] A;
		    while(true){
		    	String test = br.readLine().trim();
		    	if(test.equals("END"))
		    		break;
		    	
		        n = Integer.parseInt(br.readLine().trim());
		        String[] inputLine = br.readLine().trim().split(" ");
		        A = new int[n];
		        for(int i=0;i<n;i++){
		            A[i] = Integer.parseInt(inputLine[i]);
		        }
		       // assertEquals(expected, actual);
		        int actual = fourElements(A,n,Integer.parseInt( br.readLine().trim() ));
		        int expected = Integer.parseInt(br.readLine().trim());
		        if(actual ==  expected) {
		        	System.out.println(test+" : PASS");
		        }else {
		        	System.out.println(test+" : FAIL");
		        	System.out.println("    Expected = "+expected +" actual = "+actual);
		        }
		   }
		   }catch(Exception e){
			   
		    e.printStackTrace();
		   }
		 
	}
	
	static int fourElements(int[] A ,int n, int X){
	     HashMap<Integer,ArrayList<Node>> map = new HashMap<Integer, ArrayList<Node>>();
	     
	     ArrayList<Node> tmp=null;
	     
	     
	     for(int  i=0;i<n;i++){
	         for(int j=i+1;j<n;j++){
	             int s=A[i]+A[j];
	            tmp = map.get(s);
	            if(tmp==null) {
	            	ArrayList<Node> list = new ArrayList<Node>();
	            	list.add(new Node(i,j));
	            	map.put(s, list);
	            }else {
	            	tmp.add(new Node(i,j));
	            }
	         }
	     }
	     
	     //sum of two elements = X
	     Set<Integer> keys = map.keySet();
	     
	    // System.out.println("keys="+keys);
	     
	     ArrayList<Node> knodes;
	     
	     for(Integer key: keys){
	         if(X>=key && (tmp = map.get(X-key))!=null ){
	            knodes = map.get(key);
	            
	            if(isDistinctPair(knodes, tmp)) {
	            	return 1;
	            }
	            
	         }
	     }
	     
	     return 0;
	 }

	private static boolean isDistinctPair(ArrayList<Node> knodes, ArrayList<Node> tmp) {
		for(int i=0;i<knodes.size();i++) {
			for(int j=0;j<tmp.size();j++) {
				if( (knodes.get(i).i != tmp.get(j).i) && (knodes.get(i).j != tmp.get(j).i) && ( knodes.get(i).i != tmp.get(j).j)  && ( knodes.get(i).j != tmp.get(j).j) )
					return true;
			}
		}
		return false;
	}

}


class Node{
	int i,j;
	public Node(int i, int j){
		this.i=i;
		this.j=j;
	}
}
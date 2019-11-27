package com.tutorial.ds.sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @see Graph class for Graph representation
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * he above algorithm is simply DFS with an extra stack. So time complexity is the same as DFS which is O(V+E).
 * 
 * @author Ankit.Dixit
 *
 */
public class TopologicalSort {
	
	LinkedList<Integer>[] adjList;
	public TopologicalSort(LinkedList<Integer>[] adjList) {
		this.adjList = adjList;
	}
	
	/**
	 * 
	 * @param v : vertex
	 * @param visited : boolean array
	 * @param stack: 
	 * 
	 * @see : https://www.geeksforgeeks.org/topological-sorting/
	 * @see : https://youtu.be/Q9PIxaNGnig
	 * 
	 */
	public void topologicalSort(int v, boolean visited[], Stack stack) {
		
		visited[v] = true;
		
		Iterator<Integer> iterator = adjList[v].iterator();
		
		while(iterator.hasNext()) {
			int w = iterator.next();
			if(!visited[w]) {
				topologicalSort(w, visited, stack);
			}
		}
		stack.push(v);
	}
}

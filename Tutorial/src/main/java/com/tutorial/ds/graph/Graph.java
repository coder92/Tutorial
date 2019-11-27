package com.tutorial.ds.graph;

import com.tutorial.common.CommonClass;
import com.tutorial.ds.sorting.TopologicalSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph 
{
	private int v;
	private LinkedList<Integer> adjList[];
	
	public Graph(int v) 
	{
		this.v =v;
		adjList = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w)
	{
		adjList[v].add(w);
	}
	
	public void BFS(int s)
	{
		boolean visited[] = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[s] = true;
		
		queue.add(s);
		
		while(queue.size()!=0)
		{
			s = queue.poll();
			System.out.print(s+" ");
			
			for(Integer x: adjList[s])
			{
				if(!visited[x])
				{
					visited[x] = true;
					queue.add(x);
				}
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		int n=6;
		Graph g = new Graph(n);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 5);
		g.addEdge(0, 5);
		
		
		//System.out.println("traverse in graph");
		//g.BFS(1);
		
		boolean[] visited = new boolean[n];
		Stack stack = new Stack();
		
		Arrays.fill(visited, false);
		
		//CommonClass.printMessage("Array before topological sort")
		
		TopologicalSort sort = new TopologicalSort(g.adjList);
		sort.topologicalSort(0, visited, stack);
		
		int[] topologicalSortedArray = new int[n];
		int i=0;
		while(!stack.isEmpty()) {
			topologicalSortedArray[i++] = (int)stack.pop();
		}
		CommonClass.printMessage("topological sort");
		CommonClass.printArray(topologicalSortedArray);
		
		
	}
}

package com.tutorial.ds.sorting;


/**
 * 
 * 
 * <title>Heap Sort<title> 
 * Heap sort is a comparison based sorting technique based on Binary Heap data structure.<br> 
 * It is similar to selection sort where we first find the maximum element and place the maximum element at the end.
 * A Binary Heap is a Complete Binary Tree where items are stored in a special order such that value in a parent node is greater(or smaller) than the values in its two children nodes. 
 * The former is called as max heap and the latter is called min heap.
 * The heap can be represented by binary tree or array.
 * <br>
 * <b>Why array based representation for Binary Heap?</b><br>
 * 	Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation is space efficient. If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and right child by 2 * I + 2 (assuming the indexing starts at 0).
 * <br>
 * <h1>Pseudo code</h1>
 * {
 * 	Heap Sort Algorithm for sorting in increasing order:
	1. Build a max heap from the input data.
	2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.
	3. Repeat above steps while size of heap is greater than 1.
 * }
 * <br>
 * Heap sort is an in-place algorithm.
 * Its typical implementation is not stable, but can be made stable (See this)
 * <br>
 * <h1>Time Complexity</h1>
 * {
 * Time complexity of heapify is O(Logn). 
 * Time complexity of createAndBuildHeap() is O(n) and 
 * overall time complexity of Heap Sort is O(nLogn).
 * }
 * <br>
 * <h1>Applications of HeapSort</h1><br>
 * {
 * 1. Sort a nearly sorted (or K sorted) array
 * 2. k largest(or smallest) elements in an array
 * }
 * <br>
 * <br>
 * Reference
 * {
 * <a href = "https://www.geeksforgeeks.org/heap-sort/"> HEAP_SORT</a>
 *<br>
 * <a href="https://youtu.be/MtQL_ll5KhQ"> HS_YT</a>
 * }
 * <br>
 * @author Ankit.Dixit
 */
public class HeapSort {
	 
	public void sort(int arr[]) 
	    { 
	        int n = arr.length; 
	  
	        System.out.println("before heapify --->");
	        printArray(arr);
	        // Build heap (rearrange array) 
	        for (int i = n / 2 - 1; i >= 0; i--) 
	            heapify(arr, n, i); 
	        
	        System.out.println("======after heapify======");
	        
	        // One by one extract an element from heap 
	        for (int i=n-1; i>=0; i--) 
	        { 
	            // Move current root to end 
	            int temp = arr[0]; 
	            arr[0] = arr[i]; 
	            arr[i] = temp; 
	  
	            // call max heapify on the reduced heap 
	            heapify(arr, i, 0); 
	        } 
	    } 
	  
	    // To heapify a subtree rooted with node i which is 
	    // an index in arr[]. n is size of heap 
		/**
		 * 
		 * @param arr : array
		 * @param n : number of elements 
		 * @param i : largest element
		 */
	    void heapify(int arr[], int n, int i) 
	    { 
	    	System.out.println("heapify - i="+i+" array=");
	    	printArray(arr);
	        int largest = i; // Initialize largest as root 
	        int l = 2*i + 1; // left = 2*i + 1 
	        int r = 2*i + 2; // right = 2*i + 2 
	  
	        // If left child is larger than root 
	        if (l < n && arr[l] > arr[largest]) 
	            largest = l; 
	  
	        // If right child is larger than largest so far 
	        if (r < n && arr[r] > arr[largest]) 
	            largest = r; 
	  
	        // If largest is not root 
	        if (largest != i) 
	        { 
	            int swap = arr[i]; 
	            arr[i] = arr[largest]; 
	            arr[largest] = swap; 
	  
	            // Recursively heapify the affected sub-tree 
	            heapify(arr, n, largest); 
	        } 
	    } 
	  
	    /* A utility function to print array of size n */
	    static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        System.out.print("[");
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" |"); 
	        System.out.println("]"); 
	    } 
	  
	    // Driver program 
	    public static void main(String args[]) 
	    { 
	        int arr[] = {12, 11, 13, 5, 6, 7}; 
	        int n = arr.length; 
	  
	        HeapSort ob = new HeapSort(); 
	        
	        System.out.println("======Before Sorting ======");
	        printArray(arr);
	        ob.sort(arr); 
	        
	        System.out.println("========Sorted array is======"); 
	        printArray(arr); 
	    }
}

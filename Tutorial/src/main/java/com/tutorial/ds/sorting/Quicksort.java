package com.tutorial.ds.sorting;

import com.tutorial.common.CommonClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		Random r = new Random();
		for(int i=0;i<10;i++) {
			list.add(r.nextInt(100));
		}
		
		System.out.println("List Before Sorting>>");
		System.out.println(list);
		
		Quicksort qs = new Quicksort();
		
		list = qs.quickSort(list);
		System.out.println("List After Sorting>>");
		System.out.println(list);
		
		CommonClass.printMessage("QuickSort without using extra space.");
		
		int[] A = new int[10];
		
		for(int i=0;i<A.length;i++) {
			A[i] = r.nextInt(100);
		}
		
		quickSortWithoutExtraSpace(A, 0, A.length-1);
		
	}
	
	public List<Integer> quickSort(List<Integer> numbers){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(numbers.size()<2) return numbers;
		List<Integer> lower = new ArrayList<Integer>();
		List<Integer> higher = new ArrayList<Integer>();
		
		int pivot = numbers.get(0);
		
		for(int i=0;i<numbers.size();i++) {
			if(numbers.get(i)<pivot) {
				lower.add(numbers.get(i));
			}else if(numbers.get(i)>pivot){
				higher.add(numbers.get(i));
			}
		}
		
		
		List<Integer> sortedList = quickSort(lower);
		System.out.println("List after lower added-> "+sortedList);
		sortedList.add(pivot);
		System.out.println("List after pivot added-> "+sortedList);
		sortedList.addAll(quickSort(higher));
		System.out.println("List after higher added-> "+sortedList);
		return sortedList;
		
	}
	
	/**
	 * 
	 * {@code
	 * Psedo code
	 * <br>
	 * <code>
		quickSort(arr[], low, high)
		{
		    if (low < high)
		    {
		        
		        pi = partition(arr, low, high);
		
		        quickSort(arr, low, pi - 1);  // Before pi
		        quickSort(arr, pi + 1, high); // After pi
		    }
		}
	 * </code>
	 * }
	 * 
	 * @param A : unsorted array
	 * @param low : lower index 
	 * @param high : higher index
	 */
	public static void quickSortWithoutExtraSpace(int[] A, int low, int high) {
		int pivot = 0;
		
		if(low<high) {
			pivot = partition(A, low, high);
			
			quickSortWithoutExtraSpace(A, low, pivot-1);
			quickSortWithoutExtraSpace(A, pivot+1, high);
		}
	}

	/**
	 * Put pivot at the right place.
	 * <br>
	 * 
		
		<p>pseudo code for partition</p>
		<code>
			partition (arr[], low, high)
			{
		    // pivot (Element to be placed at right position)
		    pivot = arr[high];  
		 
		    i = (low - 1)  // Index of smaller element
		
		    for (j = low; j <= high- 1; j++)
		    {
		        // If current element is smaller than or
		        // equal to pivot
		        if (arr[j] <= pivot)
		        {
		            i++;    // increment index of smaller element
		            swap arr[i] and arr[j]
		        }
		    }
		    swap arr[i + 1] and arr[high])
		    return (i + 1)
			}
		</code>
	 * 
	 * @param A
	 * @param low
	 * @param high
	 * @return int: pivot index(right)
	 */
	private static int partition(int[] A, int low, int high) {
		int pivot = A[high];
		int i =low;
		
		CommonClass.printArray(A);
		System.out.println("low = "+low +" | high = "+high);
		CommonClass.printMessage("low to high steps");
		
		for(int j=low;j<=high-1;j++) {
			if(A[j]<=pivot) {
				swap(A,i,j);
				i++;
			}
		CommonClass.printArray(A);
		}
		swap(A, i, high);
		return i;
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}

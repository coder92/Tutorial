package com.tutorial.ds.array.problems;

import java.util.HashMap;

import com.tutorial.ds.common.TestController;

//https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents/0
public class MaxSumWithoutAdjacent implements TestControllerInterface{

	static MaxSumWithoutAdjacent obj = new MaxSumWithoutAdjacent();
	boolean debugOn = true;

	public static void main(String[] args) {

		TestController.setInput1("array\\\\problems\\\\MaxSumWithoutAdjacent.txt", obj);


	}
	HashMap<Integer, Integer> msm= new HashMap<Integer, Integer>();

	int maxSum(int[] A, int n){
		msm.clear();
		int gms=0;
		int tms;

		for(int i=0;i<n;i++){
			tms = maxSumUtil(A,i,n);
			if(gms <tms)
				gms = tms;
		}

		return gms;
	}

	int maxSumUtil(int[] A, int i, int n){
		int ms;
		Integer tms;

		tms = msm.get(i);
		if(tms !=null)
			return tms;
		ms=0;

		for(int j=i+2;j<n;j++){
			tms = msm.get(j);
			if(tms ==null)
				tms=maxSumUtil(A,j,n);

			if(tms>ms)
				ms=tms;
		}
		ms += A[i];
		msm.put(i,ms);
		//System.out.println("msm="+msm);
		return ms;
	}

	@Override
	public int startExecution() {
		return maxSum(TestController.A, TestController.n);

	}

	public  void println(String str) {
		if(debugOn)
			System.out.println(str);
	}
}


/**Input-Output
6
5 5 10 100 10 5
110

4
3 2 7 10
13

 */
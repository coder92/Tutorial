package com.tutorial.ds.array.problems;

/**
Done| Execution Time:0.25 | O(2n)
<br>
{@code
https://practice.geeksforgeeks.org/problems/unsorted-array/0/?ref=self

Given an unsorted array of size N. Find the first element in array such that all of its left 
elements are smaller and all right elements to it are greater than it.

Note: Left and right side elements can be equal to required element. 
And extreme elements cannot be required element.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. Each test case consists of two lines. 
First line of each test case contains an Integer N denoting size of array and the second line 
contains N space separated array elements.

Output:
For each test case, in a new line print the required element. If no such element present in array then print -1.

Constraints:
1 <= T <= 100
3 <= N <= 10^6
1 <= A[i] <= 10^6

Example:
Input:
3
4
4 2 5 7
3
11 9 12
6
4 3 2 7 8 9

Output:
5
-1
7
Explanation:
Testcase 1 : Elements on left of 5 are smaller than 5 and on right of it are greater than 5.
}
*/

public class ElementLeftSideSmallerRightSideGreater
{

    static int firstElement(int[] A, int n){

        //true  elements  - true who follow this property and false who do not.
        boolean[] te = new boolean[n];
        te[0] = false;
        te[n-1] = false;

        //first start with end and moving towards start.
        int min = A[n-1];
        for(int i=n-2;i>0;i--){
            if(A[i]<=min){
                min = A[i];
                te[i] = true;
            }else{
                te[i] = false;
            }
        }


        //scan the array from start to end. check the first true element and return it;
        int max = A[0];
        for(int i=1;i<=n-2;i++){
            if(te[i]){
                if(max<=A[i]){
                    max = A[i];
                    return A[i];
                }else{
                    te[i] = false;
                }
            }
            if(max<=A[i])
                max = A[i];
        }

        return -1;
    }




    public static void main(String[] args){
        
        startTest();
        
        /* 
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());

            int n;
            int[] A;
            while(t-->0){
                n = Integer.parseInt(br.readLine());
                A = new int[n];
                String[] S = br.readLine().split(" ");
                for(int i=0;i<n;i++){
                    A[i] = Integer.parseInt(S[i]);
                }
                System.out.println(firstElement(A,n));
            }
        }catch(Exception e){
            e.printStackTrace();
        } */
    }

    static void startTest(){
        String inputString;
        int[] A;
        
        inputString = "4 2 5 7";
        A= intArr(inputString);
        System.out.println(firstElement(A, A.length));

        inputString = "11 9 12";
        A= intArr(inputString);
        System.out.println(firstElement(A, A.length));

        inputString = "4 3 2 7 8 9";
        A= intArr(inputString);
        System.out.println(firstElement(A, A.length));

        inputString = "8 7 6 5 4 3 2 1";
        A= intArr(inputString);
        System.out.println(firstElement(A, A.length));

        inputString = "1 2 3 4 5 6 7";
        A= intArr(inputString);
        System.out.println(firstElement(A, A.length));
    }

    static int[] intArr(String s){
        String[] str = s.split(" ");
        int[] A = new int[str.length];
        for(int i=0;i<str.length;i++){
            A[i] = Integer.parseInt(str[i]);
        }
        return A;
    }
}

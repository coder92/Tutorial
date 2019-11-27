

package com.tutorial.ds.array.problems;


/**
Done | Execution Time:0.1 | O(n) 
<br>
https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

The cost of stock on each day is given in an array A[] of size N. 
Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Input: 
First line contains number of test cases T. 
First line of each test case contains an integer value N denoting the number of days, 
followed by an array of stock prices of N days. 

Output:
For each testcase, output all the days with profit in a single line. 
And if there is no profit then print "No Profit".

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
2
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67

Output:
(0 3) (4 6)
(1 4) (5 9)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
*/


public class StockBuySell
{
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
                String[] S = br.readLine();
                for(int i=0;i<n;i++){
                    A[i] = Integer.parseInt(S[i]);
                }
                System.out.println(maxProfit(A,n));
            }
        }catch(Exception e){
            e.printStackTrace();
        } */
    }

    /**
     * {
     * @code
     * loop(i=0 to n) 
     * if(local_minima) s = i;
     * if(local_maxima) e =i;
     * if(e>s) append (s,e) then reset s,e
     * loop finish
     * 
     * }
     * <br>
     * @param A: Array
     * @param n : 
     * @return String : max profit in format (day_start day_end) 
     */
    static String maxProfit(int[] A, int n){
        StringBuilder sb = new StringBuilder();

        //int localMin = A[0];
        int s=-1, e=-1;
        for(int i=0;i<n;i++){
            if(isLocalMinima(A, i)){
                s= i;
            }else if (isLocalMaxima(A, i)){
                e=i;
            }
            
            if(s<e){
                sb.append("("+s+" "+e+") ");
                s=e=-1;
            }
        }
        
        //System.out.println(sb.length());
        if(sb.length()==0)
            sb.append("No Profit");

        return sb.toString();
    }

    static boolean isLocalMaxima(int[] A, int i){
        if(i==A.length-1 && A[i]>A[i-1])
            return true;
        if(i==0 && A[i+1]<A[i])
            return true;
        if(A[i]>A[i+1] && A[i]>A[i-1])
            return true;
        
        return false;
    }

    static boolean isLocalMinima(int[] A, int i){
        if(i==A.length-1){
            if(A[i]<A[i-1])
                return true;
            else 
                return false;
        }
        
        if(i==0){
            if(A[i+1]>A[i])
                return true;
            else
                return true;
        }
            
        if(A[i]<A[i+1] && A[i]<A[i-1])
            return true;
        
        return false;
    }

    static void startTest(){
        String inputString;
        int[] A;
        
        inputString = "100 180 260 310 40 535 695";
        A= intArr(inputString);
        System.out.println(maxProfit(A, A.length));

        inputString = "23 13 25 29 33 19 34 45 65 67";
        A= intArr(inputString);
        System.out.println(maxProfit(A, A.length));

        inputString = "1 2 3 4 5 6 7 8";
        A= intArr(inputString);
        System.out.println(maxProfit(A, A.length));

        inputString = "8 7 6 5 4 3 2 1";
        A= intArr(inputString);
        System.out.println(maxProfit(A, A.length));
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

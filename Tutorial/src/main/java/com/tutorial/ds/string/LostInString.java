package com.tutorial.ds.string;

import java.util.ArrayList;
import java.util.List;

public class LostInString {
    public static void main(String[] args) {
        String str = "1 2 1 x";
        List<String> strList = new ArrayList<String>();
        strList.add("apple");
        solution(str, strList);
    }

    public static void solution(String inpStr, List<String> strList){
    	int s=0;
    	int e = inpStr.indexOf(' ', s);
        int a1 = Integer.parseInt(inpStr.substring(s,e));
        int p, n;
        char c;
        if(a1==1){
        	s=e;
        	e = inpStr.indexOf(' ', s+1);
            p = Integer.parseInt(inpStr.substring(s+1,e));
            
            s = e;
            e = inpStr.indexOf(' ', s+1);
            n = Integer.parseInt(inpStr.substring(s+1,e));
            
            c = inpStr.charAt(inpStr.length()-1);
            
            System.out.println(inpStr);
            System.out.println(p+" "+n+" "+c);
            
            System.out.println(strList+" | "+n);
            strList.add(strList.get(n-1).substring(0,p)+c);

            System.out.println(strList);

        }else if(a1==2){

        }else if(a1==3){

        }
    }
}

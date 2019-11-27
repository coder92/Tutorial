package com.tutorial.ds.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.tutorial.ds.array.problems.TestControllerInterface;

public class TestController {
	public static int[] A;
	public static int n;
	public static int expected;
	

	//filePath = array\\problems\\FourElementsInputFile.txt
	//4 lines 
	//1 - Array
	//2-Array
	//3-n
	//4-output
	public static void setInput1(String filePath, TestControllerInterface obj) {
		try{

			BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(new File("C:\\Users\\ankit\\Workspaces\\Tutorials\\Tutorial\\src\\main\\java\\com\\tutorial\\ds\\"+filePath))));

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
				expected = Integer.parseInt(br.readLine().trim());
				testClass(test, obj.startExecution());
				
			}
		}catch(Exception e){

			e.printStackTrace();
		}
	}

	public static void testClass(String test,int actual) {
		 if(actual ==  expected) {
	        	System.out.println(test+" : PASS");
	        }else {
	        	System.out.println(test+" : FAIL");
	        	System.out.println("    Expected = "+expected +" actual = "+actual);
	        }
	}
}

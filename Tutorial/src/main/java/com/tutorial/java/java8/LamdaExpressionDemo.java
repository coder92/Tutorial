package com.tutorial.java.java8;

/**
 * 
 * @author Ankit.Dixit
 * @see https://www.geeksforgeeks.org/lambda-expressions-java-8/
 * 
 */
public class LamdaExpressionDemo {
	public static void main(String[] args) {
		
		LamdaExpressionDemo classObj = new LamdaExpressionDemo();
		
		FunctionalInterface fObj = ()->System.out.println("Hello");
		fObj.sayHello();
		
		OperationInterface addImpl = (int x, int y)-> (x+y);
		
		OperationInterface subImpl = (int x, int y) -> (x-y);
		
		OperationInterface multiplyImpl = (int x, int y)->(x*y);
		
		OperationInterface divImpl = (int x, int y)->x/y;
		
		OperationInterface reminderImpl = (int x, int y)->x%y;
		
		System.out.println(classObj.operate(2, 3, addImpl));
		System.out.println(classObj.operate(3, 2, subImpl));
		System.out.println(classObj.operate(10, 5, multiplyImpl));
		System.out.println(classObj.operate(10, 2, divImpl));
		System.out.println(classObj.operate(10, 3, reminderImpl));
		
	}
	
	interface FunctionalInterface{
		void sayHello();
	}
	
	interface OperationInterface{
		int operation(int x, int y);
	}
	
	public int operate(int x, int y, OperationInterface operationImpl) {
		return operationImpl.operation(x, y);
	}
}



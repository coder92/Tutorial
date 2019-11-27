package com.tutorial.java.bitwise;

public class BitwiseOperatorsDemo {
	public static void main(String[] args) {
		BitwiseOperatorsDemo obj = new BitwiseOperatorsDemo();
		obj.signedRightShiftOperator(10);
	}
	
	/**
	 * Signed Right shift operator (>>) –
		Shifts the bits of the number to the right and fills 0 on voids left as a result. 
		The leftmost bit depends on the sign of initial number. 
		Similar effect as of dividing the number with some power of two.
	 * @param a
	 */
	private void signedRightShiftOperator(int a) {
		System.out.println("Binary string of a = "+a+" :"+Integer.toBinaryString(a));
		System.out.println("a>>1 : "+(a>>1) +" | Binary string = "+(Integer.toBinaryString(a>>1)));
		System.out.println("a>>2 :"+ (a>>2) +" | Binary string = "+(Integer.toBinaryString(a>>2)));
		System.out.println();
	}
}

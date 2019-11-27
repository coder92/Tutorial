package com.tutorial.notclassified;

public class ReplaceStringPerformanceTesting {


	public static void main(String[] args) {
		testReplaceWhiteSpace();
	}
	
	private static void testReplaceWhiteSpace() {
		String pCollectionString = "Read parsed events from Kafka/KafkaIO.Read/Read(KafkaUnboundedSource)/DataflowRunner.StreamingUnboundedRead.ReadWithIds.out0";
		pCollectionString =" aaa bbb ccc ddd ";
		System.out.println(replaceWhiteSpace(pCollectionString));
	}
	private static void testReplaceStringImpl() {

		
		String targetString = "ankit@kumar#dixit$abc";
		
		String replaceString = "@#$";
		String resultString;
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		resultString = replaceStringImpl(targetString, replaceString);
		endTime = System.nanoTime();
		
		System.out.println("time taken in indexOfMethod = "+(endTime-startTime));
		
		System.out.println(resultString);
		
	
	}

	private static String replaceStringImpl(String targetString, String replaceString) {

		StringBuilder resultString = new StringBuilder();

		int a=0, b=0;
		for(int i=0;i<replaceString.length();i++) {
			b = targetString.indexOf(replaceString.charAt(i), a);
			resultString.append(targetString.substring(a,b)+"_");
			a = b+1;
		}
		
		resultString.append(targetString.substring(a));
		
		return resultString.toString();

	}
	
	private static String replaceWhiteSpace(String pCollectionString) {

		if(pCollectionString==null)
			return null;
		
		pCollectionString = pCollectionString.trim();

		StringBuilder resultString = new StringBuilder();
		
		int st=0, en=0;
		
		while(true) {
			en = pCollectionString.indexOf(' ', st);
			
			if(en==-1) {
				resultString.append(pCollectionString.substring(st));
				break;
			}
			
			resultString.append(pCollectionString.substring(st, en));
			resultString.append("_");
			st = en+1;
		}
		
		return resultString.toString();
	}

}

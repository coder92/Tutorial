package com.tutorial.java.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * <h1>Why need</h1>
 * <p>Before we look into Java Stream API Examples, let’s see why it was required. 
 * Suppose we want to iterate over a list of integers and find out sum of all the integers \
 * greater than 10. Prior to Java 8, the approach to do it would be:</p> 
 * <p>
 * To overcome all the above shortcomings, Java 8 Stream API was introduced. We can use Java Stream API to implement internal iteration, that is better because java framework is in control of the iteration.
 * </p>
 * @author Ankit.Dixit
 * {@link https://www.journaldev.com/2774/java-8-stream}
 *
 */
public class StreamAPIDemo {
	
	
	
	public static void main(String[] args) {
		StreamAPIDemo obj = new StreamAPIDemo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(19);
		list.add(13);
		System.out.println(obj.sumIterator(list));
		System.out.println(obj.sumStream(list));
	}
	

	private  int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
	}

	private  int sumStream(List<Integer> list) {
		Stream<Integer> stream = list.stream();
		
		System.out.println(stream);
		
		stream = stream.filter(i->i>10);
		
		System.out.println(stream);
		
		IntStream intStream = stream.mapToInt(i->i);
		
		System.out.println(intStream);
		
		intStream.sum();
		
		return list.stream().filter(i->i>10).mapToInt(i->i).sum();
	}

}

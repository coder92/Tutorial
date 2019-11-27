package com.tutorial.java.design_pattern.creationalDP.singleton;

import java.io.*;

public class SingletonDesignPatternDemo {
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		TestSingletonSerialisedImplementation.test();
	}
}


class SingletonEagerInitialization{
	private static SingletonEagerInitialization INSTANCE = new SingletonEagerInitialization();
	
	private SingletonEagerInitialization() {
	}
	
	public static SingletonEagerInitialization getInstance() {
		return INSTANCE;
	}
}


class SingletonStaticBlockInitialization{
	private static SingletonStaticBlockInitialization INSTANCE;
	
	private SingletonStaticBlockInitialization() {
		
	}
	
	//static block - used in exception handling remain same as eager initialization
	static {
		try {
			INSTANCE = new SingletonStaticBlockInitialization();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SingletonStaticBlockInitialization getInstance() {
		return INSTANCE;
	}
}

class SingletonLazyInitialization{
	private static SingletonLazyInitialization INSTANCE;
	
	private SingletonLazyInitialization() {
		
	}
	
	public static SingletonLazyInitialization getInstance() {
		if(INSTANCE == null)
		{
			INSTANCE = new SingletonLazyInitialization();
		}
		return INSTANCE;
	}
}

class SingletonThreadSafeLazyInitialization{
	private static SingletonThreadSafeLazyInitialization INSTANCE;
	
	private SingletonThreadSafeLazyInitialization() {
		
	}
	//this will create overhead
	
	/*
	 * public static synchronized SingletonThreadSafeLazyInitialization getInstance() { if (INSTANCE == null) { INSTANCE = new
	 * SingletonThreadSafeLazyInitialization(); } return INSTANCE; }
	 */
	 
	public static SingletonThreadSafeLazyInitialization getInstance() {
		if (INSTANCE == null) {
			synchronized (SingletonThreadSafeLazyInitialization.class) {
				if(INSTANCE == null)
					INSTANCE = new SingletonThreadSafeLazyInitialization();
			}
		}
		return INSTANCE;
	}
}


class SingletonBillPughAlgoImplementation{
	
	private SingletonBillPughAlgoImplementation() {
		
	}
	
	private static class SupportiveClass{
		private static final SingletonBillPughAlgoImplementation INSTANCE = new SingletonBillPughAlgoImplementation();
	}
	
	public static SingletonBillPughAlgoImplementation getInstance() {
		return SupportiveClass.INSTANCE;
	}
	
}

class SingletonSerialisedImplementation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SingletonSerialisedImplementation() {
		
	}
	
	private static class SupportiveSingletonSerialisedImplementation{
		private static SingletonSerialisedImplementation INSTANCE = new SingletonSerialisedImplementation();
	}
	
	public static SingletonSerialisedImplementation getInstance() {
		return SupportiveSingletonSerialisedImplementation.INSTANCE;
	}
	
	public Object readResolve() {
		return getInstance();
	}
}


class TestSingletonSerialisedImplementation{
	public static void test() throws FileNotFoundException, IOException, ClassNotFoundException {
		SingletonSerialisedImplementation instanceOne = SingletonSerialisedImplementation.getInstance();
		
		ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("filename.srl"));
		
		objectOutput.writeObject(instanceOne);
		
		objectOutput.close();
		
		
		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.srl"));
		SingletonSerialisedImplementation instanceTwo = (SingletonSerialisedImplementation) in.readObject();
		in.close();
		
		
		System.out.println("instanceOne = "+instanceOne.hashCode() +" | instanceTwo = "+instanceTwo.hashCode());
	}
}

package com.tutorial.java.io.serialisation;

import java.io.*;

public class SerialisationDemo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int id;
	transient String name;
	transient int age;
	
	/**
	 * @param id
	 * @param name
	 * @param age
	 */
	public SerialisationDemo(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public void seriealise(Object obj, String fileName) {
		try {
			
			System.out.println("Object before serialisation -- "+obj);
			
			if(fileName == null)
				System.out.println("filename is null");
			
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(obj);
			
			oos.close();
			
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deserialise(String file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			
			System.out.println("Object after deserialisation-->" + obj);
			
			System.out.println(obj.toString());
			
			ois.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "SerialisationDemo [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		SerialisationDemo obj = new SerialisationDemo(1, "Ankit", 18);
		
		obj.seriealise(obj, "F:\\tmp\\SerialiseDemo.txt");
		
		obj.deserialise("F:\\tmp\\SerialiseDemo.txt");
	}
}

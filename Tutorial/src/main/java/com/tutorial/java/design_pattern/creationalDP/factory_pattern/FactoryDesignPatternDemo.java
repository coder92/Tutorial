package com.tutorial.java.design_pattern.creationalDP.factory_pattern;


public class FactoryDesignPatternDemo {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", "4 GB", "500 GB", "1.89 Ghz");
		
		System.out.println("PC = "+ pc.toString());
		
		Computer server = ComputerFactory.getComputer("server", "20 GB", "5000 GB", "4.0 Ghz");
		
		System.out.println("Server = "+server.toString());
		
		Computer superComputer = ComputerFactory.getComputer("superComputer", "400 GB", "3 PB", "1000 Ghz");
		
		System.out.println("SuperComputer = "+ superComputer.toString());
		
	}
}


class ComputerFactory{
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if(type.equalsIgnoreCase("PC")) {
			return new PC(ram, hdd, cpu);
		}else if(type.equalsIgnoreCase("Server")) {
			return new Server(ram, hdd, cpu);
		}else if(type.equalsIgnoreCase("SuperComputer")) {
			return new SuperComputer(ram, hdd, cpu);
		}else {
			System.out.println("type = "+type +" is not supported. Please enter from PC, Server, SuperComputer");
		}
		return null;
	}
}


abstract class Computer{
	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	@Override
	public String toString() {
		return "RAM ="+this.getRAM()+" | HDD = "+this.getHDD()+" | CPU = "+this.getCPU();
	}
}

class PC extends Computer{
	private String ram;
	private String hdd;
	private String cpu;
	
	public PC(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}
	
	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}
}

class Server extends Computer{

	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}
	
	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}
}

class SuperComputer extends Computer{

	private String ram;
	private String hdd;
	private String cpu;
	
	public SuperComputer(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}
	
	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}
}
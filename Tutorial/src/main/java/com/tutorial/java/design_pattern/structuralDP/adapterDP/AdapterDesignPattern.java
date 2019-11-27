package com.tutorial.java.design_pattern.structuralDP.adapterDP;

public class AdapterDesignPattern {
}

class Volt {
	private int volts;

	public Volt(int v) {
		this.volts = v;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}
}

class Socket {
	public Volt getVolt() {
		return new Volt(120);
	}
}

interface SocketAdapter {
	public Volt get120Volt();

	public Volt get12Volt();

	public Volt get3Volt();
}

package com.tutorial.notclassified;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test2 {

	public static void main(String[] args) throws UnknownHostException {
		String replicaNameString1 =  "server1";
		String replicaNameString2 =  "server12";
		String replicaNameString3 =  "server123";
		
		
		/*
		 * String serverNameString = "server";
		 * 
		 * System.out.println(replicaNameString1.contains(serverNameString));
		 * 
		 * System.out.println(replicaNameString2.contains(serverNameString));
		 * 
		 * System.out.println(replicaNameString3.contains(serverNameString));
		 */
		
		InetAddress ip = InetAddress.getLocalHost();
		
		System.out.println(ip.getHostName());
		
		System.out.println(ip.getHostAddress());
		
	}
}

package com.tutorial.java.network.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) {

		try {

			InetAddress host = InetAddress.getLocalHost();
			
			int port =3000;
			
			//Establish connection
			Socket socket = new Socket(host.getHostName(), port);
			//System.out.println("socket object has been created. socket = "+socket);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			//System.out.println("Sending request to Socket Server. oos = "+oos);
			oos.writeObject(br.readLine());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			while(socket.isConnected()) {
				
				//read from server
				String message = (String)ois.readObject();
				System.out.println("Server :"+message);
				
				//write to server
				oos.writeObject(br.readLine());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

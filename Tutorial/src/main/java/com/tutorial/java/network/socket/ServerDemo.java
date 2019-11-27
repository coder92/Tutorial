package com.tutorial.java.network.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) {

		ServerSocket server = null;
		int port = 3000;
		 ObjectInputStream ois=null;
		 Socket socket=null;
		 ObjectOutputStream oos=null;
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		try {
			//create the socket server object
			server = new ServerSocket(port);
			
			//keep listeners open till it receives 'exit' call
			//System.out.println("waiting for client connection");
			//creating socket and waiting for client connection
			socket = server.accept(); 
			//System.out.println("socket connection is accepted.");
			//read from socket to ObjectInputStream object
            ois = new ObjectInputStream(socket.getInputStream());
            //System.out.println("read from socket to ObjectInputStream object");
            //create ObjectOutputStream object
            String message = (String) ois.readObject();
            System.out.println("Client : " + message);
            oos = new ObjectOutputStream(socket.getOutputStream());
			//System.out.println("create ObjectOutputStream object");
            while(true) {
	          
	            
	          //write object to Socket
	            oos.writeObject(br.readLine());
	            //close resources
	            
	          //convert ObjectInputStream object to String
	            message = (String) ois.readObject();
	            System.out.println("Client : " + message);
	           
	            //terminate the server if client sends exit request
	            if(message.equalsIgnoreCase("exit")) break;
			}
			System.out.println("Shutting down Socket server!!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			 try {
				 ois.close();
		         oos.close();
		         socket.close();
		         server.close();
			 }catch (Exception e) {
				 e.printStackTrace();
			}
		}
	}
}

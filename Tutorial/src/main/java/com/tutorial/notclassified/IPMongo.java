package com.tutorial.notclassified;

import java.net.InetAddress;

public class IPMongo {
	
	public static void main(String[] args) {
		
		System.out.println(getHostName(args[0]));
	}
	
	public static String getHostName(String type)
	  {
	    String hostName = "";
	    
	    try
	    {
	      InetAddress ip = InetAddress.getLocalHost();
	      
	      if(type.equals("HOST"))
	        hostName = ip.getHostName();
	      else
	        hostName = ip.getHostAddress();
	      
	    }
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }	
	    
	    return hostName;
	  }
}

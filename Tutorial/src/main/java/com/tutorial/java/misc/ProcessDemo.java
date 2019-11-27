package com.tutorial.java.misc;

public class ProcessDemo  
{ 
    public static void main(String[] args) 
    { 
        try 
        { 
            // create a new process 
            System.out.println("Creating Process"); 
              
            ProcessBuilder builder = new ProcessBuilder("notepad.exe"); 
            Process pro = builder.start(); 
            
            
            ProcessBuilder builder1 = new ProcessBuilder("notepad.exe"); 
            Process pro1 = builder1.start(); 
            
            
            
            while(pro.isAlive())
            	Thread.sleep(10000);
            while(pro1.isAlive())
            	Thread.sleep(10000);
      
        }  
            catch (Exception ex)  
        { 
            ex.printStackTrace(); 
        } 
    } 
} 
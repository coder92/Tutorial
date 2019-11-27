package com.tutorial.java.jvm.src;

public class JVMClassLoaderDemo{
    public static void main(String[] args){
        System.out.println(String.class.getClassLoader()); // Bootstrap classloader
        System.out.println(JVMClassLoaderDemo.class.getClassLoader()); //Application Classloader
        System.out.println(Customer.class.getClassLoader()); // if present in extention classloader then output will be extension classloader
    }
}
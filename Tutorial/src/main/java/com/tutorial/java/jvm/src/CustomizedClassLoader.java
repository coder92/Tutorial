package com.tutorial.java.jvm.src;

import java.io.File;

public class CustomizedClassLoader {
}


class MyClassLoader extends ClassLoader {
    @SuppressWarnings("unchecked")
	public Class loadClass(String className) throws ClassNotFoundException{
        //check for updated .class file
        //new File(getClass().getClassLoader().getResource(className).getFile()).
        return Class.forName(className);
    }
}

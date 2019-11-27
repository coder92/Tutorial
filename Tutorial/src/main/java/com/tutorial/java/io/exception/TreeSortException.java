package com.tutorial.java.io.exception;

public class TreeSortException extends Exception{
	private String message;
	public TreeSortException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

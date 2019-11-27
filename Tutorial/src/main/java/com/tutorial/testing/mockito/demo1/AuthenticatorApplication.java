package com.tutorial.testing.mockito.demo1;

public class AuthenticatorApplication {
	public AuthenticatorInterface authenticatorInterface;
	
	public AuthenticatorApplication(AuthenticatorInterface authenticatorInterface) {
		this.authenticatorInterface = authenticatorInterface;
	}
	
	public boolean authenticateUser(String username, String password) {
		return authenticatorInterface.authenticateUser(username, password);
	}
}

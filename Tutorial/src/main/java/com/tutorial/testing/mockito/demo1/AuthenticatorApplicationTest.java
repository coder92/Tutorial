package com.tutorial.testing.mockito.demo1;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;


public class AuthenticatorApplicationTest {
	
	AuthenticatorInterface authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
	AuthenticatorApplication authenticator = new AuthenticatorApplication(authenticatorMock);
	
	@Test
	public void testAuthenticate() {
		
		String username = "JavaCodeGeeks";
		String password = "unsafePassword";

		when(authenticatorMock.authenticateUser(username, password))
		.thenReturn(false);

		when(authenticatorMock.authenticateUser("admin", "admin"))
		.thenReturn(true);
		
		when(authenticatorMock.authenticateUser("", ""))
		.thenThrow(new EmptyCredentialsException());

	}
	
	@Test
	public void userInput() {
		assertFalse(authenticator.authenticateUser("as","ad"));
	}
	
	@Test
	public void verifyCheck() {
		String username = "uyser";
		String password = "pass";
		verify(authenticatorMock, never()).authenticateUser("ac", "ad");
	
		
		/*
		 * verify(authenticatorMock, times(1)).authenticateUser(username, password); verify(authenticatorMock,
		 * atLeastOnce()).authenticateUser(username, password); verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
		 * verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
		 */
		
		verify(authenticatorMock, timeout(100)).authenticateUser(username, password);

			
	}
	
	@Test
	public void orderCheck() {
		InOrder inOrder = Mockito.inOrder(authenticatorMock);
		inOrder.verify(authenticatorMock).authenticateUser("abc", "abc");
	}
	
	
	
}

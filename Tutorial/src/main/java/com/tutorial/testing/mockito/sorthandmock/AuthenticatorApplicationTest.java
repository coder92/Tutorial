package com.tutorial.testing.mockito.sorthandmock;

import com.tutorial.testing.mockito.demo1.AuthenticatorApplication;
import com.tutorial.testing.mockito.demo1.AuthenticatorInterface;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest {
	@Mock
	private AuthenticatorInterface authenticatorMock;
	@InjectMocks
	private AuthenticatorApplication authenticator;
}

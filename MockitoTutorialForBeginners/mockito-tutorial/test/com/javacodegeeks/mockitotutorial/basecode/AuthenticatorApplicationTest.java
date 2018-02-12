package com.javacodegeeks.mockitotutorial.basecode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.javacodegeeks.mockitotutorial.basecode.AuthenticatorApplication;
import com.javacodegeeks.mockitotutorial.basecode.AuthenticatorInterface;
import com.javacodegeeks.mockitotutorial.basecode.EmptyCredentialsException;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatorApplicationTest {

    @Mock
    private AuthenticatorInterface authenticatorMock;
    
    @InjectMocks
    private AuthenticatorApplication authenticator;
    
    @Test
    public void testAuthenticate() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        String username = "JavaCodeGeeks";
        String password = "unsafePassword";
        
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        
        when(authenticatorMock.authenticateUser(username, password))
            .thenReturn(false);
        
        boolean actual = authenticator.authenticate(username, password);
        
        verify(authenticatorMock).authenticateUser(username, password);
        
        // verify(authenticatorMock).authenticateUser(username, "not the original password"); // This will make the test fail!
        
        verify(authenticatorMock, times(1)).authenticateUser(username, password);
        verify(authenticatorMock, atLeastOnce()).authenticateUser(username, password);
        verify(authenticatorMock, atLeast(1)).authenticateUser(username, password);
        verify(authenticatorMock, atMost(1)).authenticateUser(username, password);
      
        // verify(authenticatorMock, never()).authenticateUser(username, password); // This will make the test fail!
        
        InOrder inOrder = inOrder(authenticatorMock);
        inOrder.verify(authenticatorMock).foo();
        inOrder.verify(authenticatorMock).authenticateUser(username, password);
        
        // inOrder = inOrder(authenticatorMock);
        // inOrder.verify(authenticatorMock).authenticateUser(username, password); // This will make the test fail!
        // inOrder.verify(authenticatorMock).foo();
        
        verify(authenticatorMock, timeout(100)).authenticateUser(username, password);
        verify(authenticatorMock, timeout(100).times(1)).authenticateUser(username, password);
        
        assertFalse(actual);
    }
    
    @Test (expected = EmptyCredentialsException.class)
    public void testAuthenticateEmptyCredentialsException() throws EmptyCredentialsException {
        AuthenticatorInterface authenticatorMock;
        AuthenticatorApplication authenticator;
        
        authenticatorMock = Mockito.mock(AuthenticatorInterface.class);
        authenticator = new AuthenticatorApplication(authenticatorMock);
        
        when(authenticatorMock.authenticateUser("", ""))
            .thenThrow(new EmptyCredentialsException());
        
        authenticator.authenticate("", "");
    }

    @Test
    public void testAuthenticateMockInjection() throws EmptyCredentialsException {
        String username = "javacodegeeks";
        String password = "s4f3 p4ssw0rd";

        when(this.authenticatorMock.authenticateUser(username, password))
            .thenReturn(true);

        boolean actual = this.authenticator.authenticate("javacodegeeks", "s4f3 p4ssw0rd");
        
        assertTrue(actual);
    }
}

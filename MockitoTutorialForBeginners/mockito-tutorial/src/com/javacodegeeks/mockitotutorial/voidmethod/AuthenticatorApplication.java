package com.javacodegeeks.mockitotutorial.voidmethod;

public class AuthenticatorApplication {

	private AuthenticatorInterface authenticator;
	
	/**
     * AuthenticatorApplication constructor.
     *
     * @param authenticator Authenticator interface implementation.
     */
	public AuthenticatorApplication(AuthenticatorInterface authenticator) {
	    this.authenticator = authenticator;
	}
	
	/**
     * Tries to authenticate an user with the received user name and password, with the received
     * AuthenticatorInterface interface implementation in the constructor.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @throws NotAuthenticatedException If the user can't be authenticated.
     */
	public void authenticate(String username, String password) throws NotAuthenticatedException {
	    this.authenticator.authenticateUser(username, password);
	}
}

package com.javacodegeeks.mockitotutorial.voidmethod;

public interface AuthenticatorInterface {

    /**
     * User authentication method definition.
     *
     * @param username The user name to authenticate.
     * @param password The password to authenticate the user.
     * @throws NotAuthenticatedException If the user can't be authenticated.
     */
	public void authenticateUser(String username, String password) throws NotAuthenticatedException;

}

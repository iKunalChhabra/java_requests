package com.kunalchhabra.requests.auth;

import com.kunalchhabra.requests.props.Properties;

import java.util.Base64;

/**
 * Authentication class
 * It provides simple methods to set authentication for a request like HTTP Basic Auth and Bearer Token.
 * We can also create custom authentication methods by creating Object of this class and setting the key and value.
 * Custom Auth Example:
 * Auth auth = new Auth();
 * auth.set("Authorization", "[Type] [Token]");
 *
 * Auth class updates its key and value to request headers.
 */
public class Auth extends Properties {

    /**
     * Constructor for Auth class
     */
    public Auth() {
        super();
    }

    /**
     * Basic Auth
     * @param username Username
     * @param password Password
     */
    public void BasicAuth(String username, String password){
        byte[] authBytes = (username + ":" + password).getBytes();
        String authString = Base64.getEncoder().encodeToString(authBytes);
        this.clear();
        this.set("Authorization", "Basic " + authString);
    }

    /**
     * Bearer Token
     * @param token Token
     */
    public void BearerAuth(String token){
        this.clear();
        this.set("Authorization", "Bearer " + token);
    }
}

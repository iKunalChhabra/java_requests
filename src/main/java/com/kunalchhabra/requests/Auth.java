package com.kunalchhabra.requests;

import java.util.Base64;

public class Auth extends Properties{
    public Auth HTTPBasicAuth(String username, String password){
        byte[] authBytes = (username + ":" + password).getBytes();
        String authString = Base64.getEncoder().encodeToString(authBytes);
        this.set("Authorization", "Basic " + authString);
        return this;
    }

    public Auth HTTPBearerAuth(String token){
        this.set("Authorization", "Bearer " + token);
        return this;
    }
}

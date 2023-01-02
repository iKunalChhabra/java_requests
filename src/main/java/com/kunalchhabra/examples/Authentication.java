package com.kunalchhabra.examples;

import com.kunalchhabra.requests.auth.Auth;
import com.kunalchhabra.requests.http.HttpRequests;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;

/**
 * Examples to authenticate a request
 */
public class Authentication {

    /**
     * Constructor for Authentication class
     */
    public Authentication() {
    }

    /**
     * HTTP Basic Auth
     * @param args command line arguments
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {

        // api endpoint
        String url = "http://127.0.0.1:5000/auth";

        // headers
        Header headers = new Header();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // params
        Param params = new Param();
        params.set("id", "1");

        // auth
        Auth auth = new Auth();

        // custom authentication
        auth.set("Authorization","myToken customTokenFormat");

        // basic authentication
        auth.BasicAuth("john@email.com", "pAss123$");

        // bearer authentication
        auth.BearerAuth("JHGFG87657HGFHJ");

        // only the latest auth will be used
        auth.BasicAuth("jane@email.com", "PaSs456#");

        // create a new request and get the response
        HttpRequests requests = new HttpRequests(auth);
        Response response = requests.get(url, headers, params);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

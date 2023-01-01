package com.kunalchhabra.examples;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;
import com.kunalchhabra.requests.Auth;

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
        Auth auth = new Auth().HTTPBasicAuth("john@email.com", "pAss123$");

        // create a new request and get the response
        Requests requests = new Requests(auth);
        Response response = requests.get(url, headers, params);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

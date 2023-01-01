package com.kunalchhabra.examples;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;

import java.io.IOException;


/**
 * Examples to send a post request.
 */
public class Post {

    /**
     * Constructor for Post class
     */

    public Post() {

    }

    /**
     * Send a post request
     * @param args command line arguments
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {

        // api endpoint
        String url = "http://127.0.0.1:5000/users";

        // headers
        Header headers = new Header();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // params
        Param params = new Param();
        params.set("id", "1");

        // body
        String body = "{\"name\": \"John\", \"age\": 21}";

        // create a new request and get the response
        Requests requests = new Requests();
        Response response = requests.post(url, headers, params, body.getBytes());

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

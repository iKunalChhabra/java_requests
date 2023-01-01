package com.kunalchhabra.examples;

import com.kunalchhabra.requests.props.Body;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.http.HttpRequests;
import com.kunalchhabra.requests.response.Response;

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
        Body body = new Body();
        body.fromBase64("eyJuYW1lIjogIkpvaG4iLCAiZW1haWwiOiAiam9obkBlbWFpbC5jb20ifQ==");

        // create a new request and get the response
        HttpRequests requests = new HttpRequests();
        Response response = requests.post(url, headers, params, body);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

package com.kunalchhabra.examples;

import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.http.HttpRequests;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;

/**
 * Examples to send a get request.
 */
public class Get {

    /**
     * Constructor for Get class
     */
    public Get() {
    }

    /**
     * Send a get request
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
        params.set("id", "2");

        // create a new request and get the response
        HttpRequests requests = new HttpRequests();
        Response response = requests.get(url, headers, params);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

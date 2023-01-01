package com.kunalchhabra.examples;

import com.kunalchhabra.requests.props.Body;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.http.HttpRequests;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;
import java.util.HashMap;


/**
 * Examples to send a patch request.
 */
public class Patch {

    /**
     * Constructor for Patch class
     */
    public Patch() {

    }

    /**
     * Send a patch request
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
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "John");
        map.put("email", "john@email.com");

        Body body = new Body();
        body.fromHashMap(map);

        // create a new request and get the response
        HttpRequests requests = new HttpRequests();
        Response response = requests.patch(url, headers, params, body);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

package com.kunalchhabra.examples;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;

import java.io.IOException;


public class Post {
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
        Response response = Requests.post(url, headers, params, body.getBytes());

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

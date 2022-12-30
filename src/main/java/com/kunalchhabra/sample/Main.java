package com.kunalchhabra.sample;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        // api endpoint
        String url = "http://127.0.0.1:5000/users";

        // request headers
        Header headers = new Header();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // request params
        Param params = new Param();
        params.set("name", "Jane Doe");

        // create a new Requests object
        Requests request = new Requests();
        Response response = request.get(url, headers, params);

        // print the response
        System.out.println("Response: " + response);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("User Id: " + response.toJsonObject().getInt("id"));
    }
}

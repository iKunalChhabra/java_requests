package com.kunalchhabra.requests;

import java.io.IOException;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        // api endpoint
        String url = "http://127.0.0.1:5000/users";

        // request headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        // request params
        HashMap<String, String> params = new HashMap<>();
        params.put("name", "Jane Doe");

        // create a new Requests object
        Requests request = new Requests();
        Response response = request.get(url, headers, params);

        // print the response
        System.out.println("Response: " + response);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("User Id: " + response.toJsonObject().getInt("id"));
    }
}

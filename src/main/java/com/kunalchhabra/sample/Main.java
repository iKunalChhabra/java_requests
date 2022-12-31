package com.kunalchhabra.sample;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        // api endpoint
        String url = "https://jsonplaceholder.typicode.com/users/1";

        // create a new request and get the response
        Requests requests = new Requests();
        Response response = requests.get(url);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);
    }
}

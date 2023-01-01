package com.kunalchhabra.examples;

import com.kunalchhabra.requests.*;

import java.io.IOException;

/**
 * Examples to send a get request.
 */
public class GetAndParseJson {

    /**
     * Constructor for GetAndParseJson class
     */
    public GetAndParseJson() {
    }

    /**
     * Send a get request
     * @param args command line arguments
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {

        // create a new request and get the response
        Requests requests = new Requests();
        Response response = requests.get("http://jsonplaceholder.typicode.com/users");

        // print the response status code
        System.out.println("Status Code: " + response.getStatusCode());

        // parse and print the response
        double lat = response.toJson().get("[0]->address->geo->lat").toDouble();
        System.out.println("latitude: " + lat);
    }
}

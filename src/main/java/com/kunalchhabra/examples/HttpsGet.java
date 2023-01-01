package com.kunalchhabra.examples;

import com.kunalchhabra.requests.https.HttpsRequests;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;

/**
 * Examples to send a get request.
 */
public class HttpsGet {

    /**
     * Constructor for HttpsGet class
     */
    public HttpsGet() {
    }

    /**
     * Send a get request
     * @param args command line arguments
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {

        // create a new request and get the response
        HttpsRequests requests = new HttpsRequests();
        Response response = requests.get("https://jsonplaceholder.typicode.com/users");

        // print the response status code
        System.out.println("Status Code: " + response.getStatusCode());

        // parse and print the response
        double lat = response.toJson().get("[0]->address->geo->lat").toDouble();
        System.out.println("latitude: " + lat);
    }
}

package com.kunalchhabra.examples;

import com.kunalchhabra.requests.https.HttpsRequests;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.props.ResponseHeader;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;
import java.util.Arrays;

/**
 * Examples to get various response types.
 */
public class ResponseTypes {

    /**
     * Constructor for ResponseTypes class
     */

    public ResponseTypes() {

    }

    /**
     * Get the response as a string.
     * @param args command line arguments
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {

        // api endpoint
        String url = "https://jsonplaceholder.typicode.com/users/1";

        // headers
        Header headers = new Header();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        // params
        Param params = new Param();
        params.set("id", "1");

        // create a new request and get the response
        HttpsRequests requests = new HttpsRequests();
        Response response = requests.get(url, headers, params);

        // print the response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response);

        // get text
        System.out.println("Text: " + response.toText());

        // get hash
        System.out.println("MD5 Hash: " + response.toHash().getMD5());
        System.out.println("SHA1 Hash: " + response.toHash().getSHA1());
        System.out.println("SHA256 Hash: " + response.toHash().getSHA256());
        System.out.println("SHA512 Hash: " + response.toHash().getSHA512());

        // get base64
        System.out.println("Base64: " + response.toBase64());

        // get json
        System.out.println("JSON: " + response.toJsonObject());

        // get bytes
        System.out.println("Bytes: " + Arrays.toString(response.toBytes()));

        // save to file
        response.toFile("src/main/java/com/kunalchhabra/examples/response.json");

        // get headers
        ResponseHeader responseHeaders = response.getHeaders();
        System.out.println("Headers: " + responseHeaders);

    }
}

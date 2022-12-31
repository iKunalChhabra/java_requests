package com.kunalchhabra.examples;

import com.kunalchhabra.requests.Header;
import com.kunalchhabra.requests.Param;
import com.kunalchhabra.requests.Requests;
import com.kunalchhabra.requests.Response;
import com.kunalchhabra.requests.ResponseHeader;

import java.io.IOException;
import java.util.Arrays;


public class ResponseTypes {
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

        // create a new request and get the response
        Response response = Requests.get(url, headers, params);

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

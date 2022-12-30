package com.kunalchhabra.requests;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Requests {
    private void setHeaders(HttpURLConnection connection, Header headers){
        headers.forEach(connection::setRequestProperty);
    }
    private String setParams(String url, Param params) {
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params.size() > 0) {
            urlBuilder.append("?");
            for (String key : params.keySet()) {
                String value = URLEncoder.encode(params.get(key), StandardCharsets.UTF_8);
                urlBuilder.append(key).append("=").append(value).append("&");
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }
        return urlBuilder.toString();
    }

    private String readResponse(InputStream input) {
        Scanner scanner = new Scanner(input);
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        return response.toString();
    }

    private String readData(HttpURLConnection connection) throws IOException {
        return readResponse(connection.getInputStream());
    }

    private String readError(HttpURLConnection connection) {
        return readResponse(connection.getErrorStream());
    }
    public Response get(String url, Header headers, Param params) throws IOException {
        url = this.setParams(url, params);

        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestMethod("GET");
        this.setHeaders(connection, headers);


        connection.connect();
        int statusCode = connection.getResponseCode();
        String data;
        if (statusCode == 200) {
            data = this.readData(connection);
        }
        else {
            data = this.readError(connection);
        }
        connection.disconnect();

        return new Response(statusCode, data);
    }
    public Response get(String url, Header headers) throws IOException {
        Param params = new Param();
        return this.get(url, headers, params);
    }
    public Response get(String url) throws IOException {
        Header headers = new Header();
        return this.get(url, headers);
    }
}


package com.kunalchhabra.requests;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Scanner;

class Response{
    private int statusCode;
    private String data;

    public Response(int statusCode, String data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return this.data;
    }

    public JSONObject toJsonObject(){
        return new JSONObject(this.data);
    }

    public JSONArray toJsonArray(){
        return new JSONArray(this.data);
    }
}

public class Requests {
    private void setHeaders(HttpURLConnection connection, HashMap<String, String> headers){
        headers.forEach(connection::setRequestProperty);
    }
    private String setParams(String url, HashMap<String, String> params) throws IOException {
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

    private String readResponse(InputStream input) throws IOException {
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

    private String readError(HttpURLConnection connection) throws IOException {
        return readResponse(connection.getErrorStream());
    }
    public Response get(String url, HashMap<String, String> headers, HashMap<String, String> params) throws IOException {
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
    public Response get(String url, HashMap<String, String> headers) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        return this.get(url, headers, params);
    }
    public Response get(String url) throws IOException {
        HashMap<String, String> headers = new HashMap<>();
        return this.get(url, headers);
    }
}


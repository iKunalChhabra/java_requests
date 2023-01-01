package com.kunalchhabra.requests;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Utils {
    protected static HttpURLConnection createConnection(String url, String method, Header headers, Param params, Auth auth) throws IOException {
        url = Utils.setParams(url, params);

        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestMethod(method);
        Utils.setHeaders(connection, headers);
        Utils.setAuth(connection, auth);
        return connection;
    }

    protected static Response readConnection(HttpURLConnection connection) throws IOException {
        connection.connect();
        int statusCode = connection.getResponseCode();
        ResponseHeader headers = new ResponseHeader(connection.getHeaderFields());
        byte[] byteData;
        if (statusCode == 200) {
            byteData = Utils.readData(connection);
        }
        else {
            byteData = Utils.readError(connection);
        }
        connection.disconnect();

        return new Response(statusCode, byteData, headers);
    }

    protected static void setHeaders(HttpURLConnection connection, Header headers){
        headers.forEach(connection::setRequestProperty);
    }
    protected static String setParams(String url, Param params) {
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

    protected static byte[] readResponse(InputStream input) throws IOException {
        return input.readAllBytes();
    }

    protected static byte[] readData(HttpURLConnection connection) throws IOException {
        return readResponse(connection.getInputStream());
    }

    protected static byte[] readError(HttpURLConnection connection) throws IOException {
        return readResponse(connection.getErrorStream());
    }

    protected static void setData(HttpURLConnection connection, byte[] byteDate) throws IOException {
        if (byteDate.length > 0) {
            connection.setDoOutput(true);
            connection.getOutputStream().write(byteDate);
        }
    }

    protected static void setAuth(HttpURLConnection connection, Auth auth) {
        for (String key : auth.keySet()) {
            connection.setRequestProperty(key, auth.get(key));
        }
    }
}

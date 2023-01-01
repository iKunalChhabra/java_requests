package com.kunalchhabra.requests;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * Utility class for various common methods
 */
public class Utils {

    /**
     * Create a HTTP Connection.
     * @param url the url to connect to
     * @param method the HTTP method to use
     * @param headers the headers to use
     * @param params the params to use
     * @param auth the auth to use
     *
     * @return the HTTP Connection
     */
    protected static HttpURLConnection createConnection(String url, String method, Header headers, Param params, Auth auth) throws IOException {
        url = Utils.setParams(url, params);

        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestMethod(method);
        Utils.setHeaders(connection, headers);
        Utils.setAuth(connection, auth);
        return connection;
    }


    /**
     * Read the Status code, response headers and response body from the HTTP Connection.
     *
     * @param connection the HTTP Connection
     *
     * @return the Response
     *
     * @throws IOException
     */
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

    /**
     * Set the headers for the HTTP Connection.
     * @param connection the HTTP Connection
     * @param headers the headers to use
     */
    protected static void setHeaders(HttpURLConnection connection, Header headers){
        headers.forEach(connection::setRequestProperty);
    }

    /**
     * Set the parameters for the HTTP Connection.
     * @param url the url to connect to
     * @param params the params to use
     *
     * @return the new url with the parameters
     */
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

    /**
     * Common method to read input stream from the HTTP Connection.
     *
     * @param input the input stream
     *
     * @return the byte array of the input stream
     */
    protected static byte[] readResponse(InputStream input) throws IOException {
        return input.readAllBytes();
    }


    /**
     * Read the response body from the HTTP Connection.
     *
     * @param connection the HTTP Connection
     *
     * @return the byte array of the response body
     */
    protected static byte[] readData(HttpURLConnection connection) throws IOException {
        return readResponse(connection.getInputStream());
    }

    /**
     * Read the error body from the HTTP Connection.
     *
     * @param connection the HTTP Connection
     *
     * @return the byte array of the error body
     */
    protected static byte[] readError(HttpURLConnection connection) throws IOException {
        return readResponse(connection.getErrorStream());
    }

    /**
     * Send data for POST, PUT and PATCH requests.
     *
     * @param connection the HTTP Connection
     * @param byteDate the byte array of the data to send
     */
    protected static void setData(HttpURLConnection connection, byte[] byteDate) throws IOException {
        if (byteDate.length > 0) {
            connection.setDoOutput(true);
            connection.getOutputStream().write(byteDate);
        }
    }

    /**
     * Set the auth for the HTTP Connection.
     * @param connection the HTTP Connection
     * @param auth the auth to use
     */
    protected static void setAuth(HttpURLConnection connection, Auth auth) {
        for (String key : auth.keySet()) {
            connection.setRequestProperty(key, auth.get(key));
        }
    }
}

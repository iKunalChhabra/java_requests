package com.kunalchhabra.requests;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Requests {

    // GET
    public static Response get(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "GET", headers, params);
        return Utils.readConnection(connection);
    }
    public static Response get(String url, Header headers) throws IOException {
        return Requests.get(url, headers, new Param());
    }
    public static Response get(String url) throws IOException {
        return Requests.get(url, new Header());
    }

    // POST
    public static Response post(String url, Header headers, Param params, byte[] byteData) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params);
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }
    public static Response post(String url, Header headers, Param params) throws IOException {
        return Requests.post(url, headers, params, new byte[0]);
    }

    public static Response post(String url, Header headers, String data) throws IOException {
        return Requests.post(url, headers, new Param(), new byte[0]);
    }

    public static Response post(String url, Header headers) throws IOException {
        return Requests.post(url, headers, new Param(), new byte[0]);
    }

    public static Response post(String url) throws IOException {
        return Requests.post(url, new Header());
    }

    // PUT
    public static Response put(String url, Header headers, Param params, byte[] byteData) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "PUT", headers, params);
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }
    public static Response put(String url, Header headers, Param params) throws IOException {
        return Requests.put(url, headers, params, new byte[0]);
    }

    public static Response put(String url, Header headers, String data) throws IOException {
        return Requests.put(url, headers, new Param(), new byte[0]);
    }

    public static Response put(String url, Header headers) throws IOException {
        return Requests.put(url, headers, new Param(), new byte[0]);
    }

    public static Response put(String url) throws IOException {
        return Requests.put(url, new Header());
    }

    // PATCH
    public static Response patch(String url, Header headers, Param params, byte[] byteData) throws IOException {
        System.out.println("Warning: 'PATCH' Method is not supported by Java's 'HttpURLConnection' used by this library." +
                           " This library uses 'POST' method in request but overrides the method to 'PATCH' using HTTP header 'X-HTTP-Method-Override'." +
                           " This may not work with some servers.");

        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params);
        connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }

    public static Response patch(String url, Header headers, Param params) throws IOException {
        return Requests.patch(url, headers, params, new byte[0]);
    }

    public static Response patch(String url, Header headers, String data) throws IOException {
        return Requests.patch(url, headers, new Param(), new byte[0]);
    }

    public static Response patch(String url, Header headers) throws IOException {
        return Requests.patch(url, headers, new Param(), new byte[0]);
    }

    public static Response patch(String url) throws IOException {
        return Requests.patch(url, new Header());
    }

    // DELETE
    public static Response delete(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "DELETE", headers, params);
        return Utils.readConnection(connection);
    }

    public static Response delete(String url, Header headers) throws IOException {
        return Requests.delete(url, headers, new Param());
    }

    public static Response delete(String url) throws IOException {
        return Requests.delete(url, new Header());
    }
}


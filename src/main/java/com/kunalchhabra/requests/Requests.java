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


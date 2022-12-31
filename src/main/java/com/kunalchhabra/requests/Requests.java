package com.kunalchhabra.requests;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Requests {

    // GET
    public Response get(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "GET", headers, params);
        return Utils.readConnection(connection);
    }
    public Response get(String url, Header headers) throws IOException {
        return this.get(url, headers, new Param());
    }
    public Response get(String url) throws IOException {
        return this.get(url, new Header());
    }

    // POST
    public Response post(String url, Header headers, Param params, byte[] byteDate) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params);
        Utils.setData(connection, byteDate);
        return Utils.readConnection(connection);
    }
    public Response post(String url, Header headers, Param params) throws IOException {
        return this.post(url, headers, params, new byte[0]);
    }

    public Response post(String url, Header headers, String data) throws IOException {
        return this.post(url, headers, new Param(), new byte[0]);
    }

    public Response post(String url, Header headers) throws IOException {
        return this.post(url, headers, new Param(), new byte[0]);
    }

    public Response post(String url) throws IOException {
        return this.post(url, new Header());
    }

    // PUT
    public Response put(String url, Header headers, Param params, byte[] byteDate) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "PUT", headers, params);
        Utils.setData(connection, byteDate);
        return Utils.readConnection(connection);
    }
    public Response put(String url, Header headers, Param params) throws IOException {
        return this.put(url, headers, params, new byte[0]);
    }

    public Response put(String url, Header headers, String data) throws IOException {
        return this.put(url, headers, new Param(), new byte[0]);
    }

    public Response put(String url, Header headers) throws IOException {
        return this.put(url, headers, new Param(), new byte[0]);
    }

    public Response put(String url) throws IOException {
        return this.put(url, new Header());
    }

    // DELETE
    public Response delete(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "DELETE", headers, params);
        return Utils.readConnection(connection);
    }

    public Response delete(String url, Header headers) throws IOException {
        return this.delete(url, headers, new Param());
    }

    public Response delete(String url) throws IOException {
        return this.delete(url, new Header());
    }
}


package com.kunalchhabra.requests;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Requests {
    private Auth auth = new Auth();
    public Requests(){
    }
    public Requests(Auth auth){
        this.auth = auth;
    }

    // GET
    public Response get(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "GET", headers, params, this.auth);
        return Utils.readConnection(connection);
    }
    public Response get(String url, Header headers) throws IOException {
        return this.get(url, headers, new Param());
    }
    public Response get(String url) throws IOException {
        return this.get(url, new Header());
    }

    // POST
    public Response post(String url, Header headers, Param params, byte[] byteData) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params,this.auth);
        Utils.setData(connection, byteData);
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
    public Response put(String url, Header headers, Param params, byte[] byteData) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "PUT", headers, params,this.auth);
        Utils.setData(connection, byteData);
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

    // PATCH
    public Response patch(String url, Header headers, Param params, byte[] byteData) throws IOException {
        System.out.println("Warning: 'PATCH' Method is not supported by Java's 'HttpURLConnection' used by this library." +
                           " This library uses 'POST' method in request but overrides the method to 'PATCH' using HTTP header 'X-HTTP-Method-Override'." +
                           " This may not work with some servers.");

        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params,this.auth);
        connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }

    public Response patch(String url, Header headers, Param params) throws IOException {
        return this.patch(url, headers, params, new byte[0]);
    }

    public Response patch(String url, Header headers, String data) throws IOException {
        return this.patch(url, headers, new Param(), new byte[0]);
    }

    public Response patch(String url, Header headers) throws IOException {
        return this.patch(url, headers, new Param(), new byte[0]);
    }

    public Response patch(String url) throws IOException {
        return this.patch(url, new Header());
    }

    // DELETE
    public Response delete(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "DELETE", headers, params,this.auth);
        return Utils.readConnection(connection);
    }

    public Response delete(String url, Header headers) throws IOException {
        return this.delete(url, headers, new Param());
    }

    public Response delete(String url) throws IOException {
        return this.delete(url, new Header());
    }
}


package com.kunalchhabra.requests;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * This class is used to create a new request.
 */
public class Requests {
    private Auth auth = new Auth();

    /**
     * Creates a new request with no authentication.
     */
    public Requests(){
    }

    /**
     * Creates a new request with authentication.
     * @param auth The authentication object.
     */
    public Requests(Auth auth){
        this.auth = auth;
    }

    // GET
    /**
     * Creates a new GET request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response get(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "GET", headers, params, this.auth);
        return Utils.readConnection(connection);
    }

    /**
     * Creates a new GET request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response get(String url, Header headers) throws IOException {
        return this.get(url, headers, new Param());
    }

    /**
     * Creates a new GET request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException
     */
    public Response get(String url) throws IOException {
        return this.get(url, new Header());
    }

    // POST

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @param byteData The byte data to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response post(String url, Header headers, Param params, byte[] byteData) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params,this.auth);
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response post(String url, Header headers, Param params) throws IOException {
        return this.post(url, headers, params, new byte[0]);
    }

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response post(String url, Header headers) throws IOException {
        return this.post(url, headers, new Param(), new byte[0]);
    }

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException
     */
    public Response post(String url) throws IOException {
        return this.post(url, new Header());
    }

    // PUT

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @param byteData The byte data to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response put(String url, Header headers, Param params, byte[] byteData) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "PUT", headers, params,this.auth);
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response put(String url, Header headers, Param params) throws IOException {
        return this.put(url, headers, params, new byte[0]);
    }

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response put(String url, Header headers) throws IOException {
        return this.put(url, headers, new Param(), new byte[0]);
    }

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException
     */
    public Response put(String url) throws IOException {
        return this.put(url, new Header());
    }

    // PATCH

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @param byteData The byte data to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response patch(String url, Header headers, Param params, byte[] byteData) throws IOException {
        System.out.println("Warning: 'PATCH' Method is not supported by Java's 'HttpURLConnection' used by this library." +
                           " This library uses 'POST' method in request but overrides the method to 'PATCH' using HTTP header 'X-HTTP-Method-Override'." +
                           " This may not work with some servers.");

        HttpURLConnection connection = Utils.createConnection(url, "POST", headers, params,this.auth);
        connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        Utils.setData(connection, byteData);
        return Utils.readConnection(connection);
    }

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response patch(String url, Header headers, Param params) throws IOException {
        return this.patch(url, headers, params, new byte[0]);
    }

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response patch(String url, Header headers) throws IOException {
        return this.patch(url, headers, new Param(), new byte[0]);
    }

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException
     */
    public Response patch(String url) throws IOException {
        return this.patch(url, new Header());
    }

    // DELETE

    /**
     * Creates a new DELETE request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response delete(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = Utils.createConnection(url, "DELETE", headers, params,this.auth);
        return Utils.readConnection(connection);
    }

    /**
     * Creates a new DELETE request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException
     */
    public Response delete(String url, Header headers) throws IOException {
        return this.delete(url, headers, new Param());
    }

    /**
     * Creates a new DELETE request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException
     */
    public Response delete(String url) throws IOException {
        return this.delete(url, new Header());
    }
}


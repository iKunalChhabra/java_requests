package com.kunalchhabra.requests.http;

import com.kunalchhabra.requests.auth.Auth;
import com.kunalchhabra.requests.props.Body;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.response.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * This class is used to create a new request.
 */
public class HttpRequests {
    private Auth auth = new Auth();

    /**
     * Creates a new request with no authentication.
     */
    public HttpRequests(){
    }

    /**
     * Creates a new request with authentication.
     * @param auth The authentication object.
     */
    public HttpRequests(Auth auth){
        this.auth = auth;
    }

    // GET
    /**
     * Creates a new GET request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response get(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = HttpUtils.createConnection(url, "GET", headers, params, this.auth);
        return HttpUtils.readConnection(connection);
    }

    /**
     * Creates a new GET request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response get(String url, Header headers) throws IOException {
        return this.get(url, headers, new Param());
    }

    /**
     * Creates a new GET request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException IOException
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
     * @param body The byte data to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response post(String url, Header headers, Param params, Body body) throws IOException {
        HttpURLConnection connection = HttpUtils.createConnection(url, "POST", headers, params,this.auth);
        HttpUtils.setData(connection, body.toBytes());
        return HttpUtils.readConnection(connection);
    }

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response post(String url, Header headers, Param params) throws IOException {
        return this.post(url, headers, params, new Body());
    }

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response post(String url, Header headers) throws IOException {
        return this.post(url, headers, new Param(), new Body());
    }

    /**
     * Creates a new POST request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException IOException
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
     * @param body The byte data to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response put(String url, Header headers, Param params, Body body) throws IOException {
        HttpURLConnection connection = HttpUtils.createConnection(url, "PUT", headers, params,this.auth);
        HttpUtils.setData(connection, body.toBytes());
        return HttpUtils.readConnection(connection);
    }

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response put(String url, Header headers, Param params) throws IOException {
        return this.put(url, headers, params, new Body());
    }

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response put(String url, Header headers) throws IOException {
        return this.put(url, headers, new Param(), new Body());
    }

    /**
     * Creates a new PUT request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException IOException
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
     * @param body The byte data to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response patch(String url, Header headers, Param params, Body body) throws IOException {
        System.out.println("Warning: 'PATCH' Method is not supported by Java's 'HttpURLConnection' used by this library." +
                           " This library uses 'POST' method in request but overrides the method to 'PATCH' using HTTP header 'X-HTTP-Method-Override'." +
                           " This may not work with some servers.");

        HttpURLConnection connection = HttpUtils.createConnection(url, "POST", headers, params,this.auth);
        connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        HttpUtils.setData(connection, body.toBytes());
        return HttpUtils.readConnection(connection);
    }

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @param params The parameters to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response patch(String url, Header headers, Param params) throws IOException {
        return this.patch(url, headers, params, new Body());
    }

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response patch(String url, Header headers) throws IOException {
        return this.patch(url, headers, new Param(), new Body());
    }

    /**
     * Creates a new PATCH request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException IOException
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
     * @throws IOException IOException
     */
    public Response delete(String url, Header headers, Param params) throws IOException {
        HttpURLConnection connection = HttpUtils.createConnection(url, "DELETE", headers, params,this.auth);
        return HttpUtils.readConnection(connection);
    }

    /**
     * Creates a new DELETE request.
     * @param url The URL to send the request to.
     * @param headers The headers to send with the request.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response delete(String url, Header headers) throws IOException {
        return this.delete(url, headers, new Param());
    }

    /**
     * Creates a new DELETE request.
     * @param url The URL to send the request to.
     * @return The response object.
     * @throws IOException IOException
     */
    public Response delete(String url) throws IOException {
        return this.delete(url, new Header());
    }
}


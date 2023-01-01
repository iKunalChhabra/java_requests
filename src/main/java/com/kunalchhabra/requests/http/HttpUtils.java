package com.kunalchhabra.requests.http;

import com.kunalchhabra.requests.auth.Auth;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.props.ResponseHeader;
import com.kunalchhabra.requests.response.Response;
import com.kunalchhabra.requests.utils.CommonUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Utility class for various common HTTP methods
 */
public class HttpUtils {

    /** Constructor for Utils class
     */
    private HttpUtils() {
    }

    /**
     * Create a HTTP Connection.
     * @param url the url to connect to
     * @param method the HTTP method to use
     * @param headers the headers to use
     * @param params the params to use
     * @param auth the auth to use
     *
     * @return the HTTP Connection
     * @throws IOException IOException
     */
    protected static HttpURLConnection createConnection(String url, String method, Header headers, Param params, Auth auth) throws IOException {
        url = CommonUtils.setParams(url, params);

        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestMethod(method);
        HttpUtils.setHeaders(connection, headers);
        HttpUtils.setAuth(connection, auth);
        return connection;
    }


    /**
     * Read the Status code, response headers and response body from the HTTP Connection.
     *
     * @param connection the HTTP Connection
     *
     * @return the Response
     *
     * @throws IOException IOException
     */
    protected static Response readConnection(HttpURLConnection connection) throws IOException {
        connection.connect();
        int statusCode = connection.getResponseCode();
        ResponseHeader headers = new ResponseHeader(connection.getHeaderFields());
        byte[] byteData;
        if (statusCode == 200) {
            byteData = HttpUtils.readData(connection);
        }
        else {
            byteData = HttpUtils.readError(connection);
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
     * Read the response body from the HTTP Connection.
     *
     * @param connection the HTTP Connection
     *
     * @return the byte array of the response body
     * @throws IOException IOException
     */
    protected static byte[] readData(HttpURLConnection connection) throws IOException {
        return CommonUtils.readResponse(connection.getInputStream());
    }

    /**
     * Read the error body from the HTTP Connection.
     *
     * @param connection the HTTP Connection
     *
     * @return the byte array of the error body
     * @throws IOException IOException
     */
    protected static byte[] readError(HttpURLConnection connection) throws IOException {
        return CommonUtils.readResponse(connection.getErrorStream());
    }

    /**
     * Send data for POST, PUT and PATCH requests.
     *
     * @param connection the HTTP Connection
     * @param byteDate the byte array of the data to send
     * @throws IOException IOException
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

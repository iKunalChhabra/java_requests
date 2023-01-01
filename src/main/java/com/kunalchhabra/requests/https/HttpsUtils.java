package com.kunalchhabra.requests.https;

import com.kunalchhabra.requests.auth.Auth;
import com.kunalchhabra.requests.props.Header;
import com.kunalchhabra.requests.props.Param;
import com.kunalchhabra.requests.props.ResponseHeader;
import com.kunalchhabra.requests.response.Response;
import com.kunalchhabra.requests.utils.CommonUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;


/**
 * Utility class for various common HTTPS methods
 */
public class HttpsUtils {

    /** Constructor for Utils class
     */
    private HttpsUtils() {
    }

    /**
     * Create a HTTP Connection.
     * @param url the url to connect to
     * @param method the HTTPS method to use
     * @param headers the headers to use
     * @param params the params to use
     * @param auth the auth to use
     *
     * @return the HTTP Connection
     * @throws IOException IOException
     */
    protected static HttpsURLConnection createConnection(String url, String method, Header headers, Param params, Auth auth) throws IOException {
        url = CommonUtils.setParams(url, params);

        URL urlObject = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) urlObject.openConnection();

        connection.setRequestMethod(method);
        HttpsUtils.setHeaders(connection, headers);
        HttpsUtils.setAuth(connection, auth);
        return connection;
    }


    /**
     * Read the Status code, response headers and response body from the HTTPS Connection.
     *
     * @param connection the HTTPS Connection
     *
     * @return the Response
     *
     * @throws IOException IOException
     */
    protected static Response readConnection(HttpsURLConnection connection) throws IOException {
        connection.connect();
        int statusCode = connection.getResponseCode();
        ResponseHeader headers = new ResponseHeader(connection.getHeaderFields());
        byte[] byteData;
        if (statusCode == 200) {
            byteData = HttpsUtils.readData(connection);
        }
        else {
            byteData = HttpsUtils.readError(connection);
        }
        connection.disconnect();

        return new Response(statusCode, byteData, headers);
    }

    /**
     * Set the headers for the HTTPS Connection.
     * @param connection the HTTPS Connection
     * @param headers the headers to use
     */
    protected static void setHeaders(HttpsURLConnection connection, Header headers){
        headers.forEach(connection::setRequestProperty);
    }

    /**
     * Read the response body from the HTTPS Connection.
     *
     * @param connection the HTTPS Connection
     *
     * @return the byte array of the response body
     * @throws IOException IOException
     */
    protected static byte[] readData(HttpsURLConnection connection) throws IOException {
        return CommonUtils.readResponse(connection.getInputStream());
    }

    /**
     * Read the error body from the HTTPS Connection.
     *
     * @param connection the HTTPS Connection
     *
     * @return the byte array of the error body
     * @throws IOException IOException
     */
    protected static byte[] readError(HttpsURLConnection connection) throws IOException {
        return CommonUtils.readResponse(connection.getErrorStream());
    }

    /**
     * Send data for POST, PUT and PATCH requests.
     *
     * @param connection the HTTPS Connection
     * @param byteDate the byte array of the data to send
     * @throws IOException IOException
     */
    protected static void setData(HttpsURLConnection connection, byte[] byteDate) throws IOException {
        if (byteDate.length > 0) {
            connection.setDoOutput(true);
            connection.getOutputStream().write(byteDate);
        }
    }

    /**
     * Set the auth for the HTTPS Connection.
     * @param connection the HTTPS Connection
     * @param auth the auth to use
     */
    protected static void setAuth(HttpsURLConnection connection, Auth auth) {
        for (String key : auth.keySet()) {
            connection.setRequestProperty(key, auth.get(key));
        }
    }
}

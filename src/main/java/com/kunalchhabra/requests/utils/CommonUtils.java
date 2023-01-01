package com.kunalchhabra.requests.utils;

import com.kunalchhabra.requests.props.Param;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for various common methods
 */
public class CommonUtils {

    /** Constructor for CommonUtils class
     */
    public  CommonUtils() {
    }

    /**
     * Common method to read input stream from the HTTP Connection.
     *
     * @param input the input stream
     *
     * @return the byte array of the input stream
     * @throws IOException IOException
     */
    public static byte[] readResponse(InputStream input) throws IOException {
        return input.readAllBytes();
    }

    /**
     * Set the parameters for the HTTP Connection.
     * @param url the url to connect to
     * @param params the params to use
     *
     * @return the new url with the parameters
     */
    public static String setParams(String url, Param params) {
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
}

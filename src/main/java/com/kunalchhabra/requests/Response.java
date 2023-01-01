package com.kunalchhabra.requests;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Response class
 */
public class Response {
    private final int statusCode;
    private final byte[] byteData;
    private final ResponseHeader headers;

    /**
     * Constructor
     *
     * @param statusCode status code
     * @param byteData   byte data
     * @param headers    response headers
     */
    protected Response(int statusCode, byte[] byteData, ResponseHeader headers) {
        this.statusCode = statusCode;
        this.byteData = byteData;
        this.headers = headers;
    }

    /**
     * Get the status code like 200, 404, 500 etc.
     *
     * @return status code
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * Get the response headers like Content-Type, Content-Length etc.
     *
     * @return response headers
     */
    public ResponseHeader getHeaders() {
        return this.headers;
    }

    /**
     * Get the response body as a string
     *
     * @return response body as a string
     */

    public String toString() {
        return new String(this.byteData, StandardCharsets.UTF_8);
    }

    /**
     * Get the response body as String
     *
     * @return response body as String
     */

    public String toText() {
        return this.toString();
    }

    /**
     * Get the response body as a JSONObject
     *
     * @return response body as a JSONObject
     */

    public JSONObject toJsonObject() {
        return new JSONObject(this.toString());
    }

    /**
     * Get the response body as a JSONArray
     *
     * @return response body as a JSONArray
     */

    public JSONArray toJsonArray() {
        return new JSONArray(this.toString());
    }

    /**
     * Get the response body as a JsonParser
     *
     * @return response body as a JsonParser
     */

    public JsonParser toJson() {
        if (this.toString().startsWith("[")) {
            return new JsonParser(this.toJsonArray());
        }
        else{
            return new JsonParser(this.toJsonObject());
        }
    }

    /**
     * Get the response body as a byte array
     *
     * @return response body as a byte array
     */

    public byte[] toBytes() {
        return this.byteData;
    }

    /**
     * Get the response body as a Base64 encoded string
     *
     * @return response body as a Base64 encoded string
     */
    public String toBase64() {
        return Base64.getEncoder().encodeToString(this.toBytes());
    }

    /**
     * Save the response body to a file
     *
     * @param filePath file path
     * @throws IOException IOException
     */

    public void toFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, this.toBytes());
    }

    /**
     * Get the Hash of response body as Hexadecimal String
     *
     * @return Hash of response body as Hexadecimal String
     */
    public Hash toHash() {
        return new Hash(this.toBytes());
    }
}
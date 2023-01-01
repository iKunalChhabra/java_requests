package com.kunalchhabra.requests.props;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Body class
 */
public class Body {

    private byte[] byteArray;

    /**
     * Constructor
     */
    public Body() {

    }

    /**
     * Method to prepare request body from file
     *
     * @param filePath path to file
     * @throws IOException IOException
     */
    public void fromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        // read file
        this.byteArray = Files.readAllBytes(path);

    }


    /**
     * Method to prepare request body from byte array
     *
     * @param byteArray byte array
     */
    public void fromBytes(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    /**
     * Method to prepare request body from string
     *
     * @param text string
     */
    public void fromString(String text) {
        this.byteArray = text.getBytes();
    }

    /**
     * Method to prepare request body from BASE64 encoded string
     *
     * @param hexString BASE64 encoded string
     */
    public void fromBase64(String hexString) {
        this.byteArray = java.util.Base64.getDecoder().decode(hexString);
    }

    /**
     * Method to prepare request body from JSON object
     *
     * @param jsonObject JSON object
     */
    public void fromJsonObject(JSONObject jsonObject) {
        this.byteArray = jsonObject.toString().getBytes();
    }

    /**
     * Method to prepare request body from JSON array
     *
     * @param jsonArray JSON array
     */
    public void fromJsonArray(JSONArray jsonArray) {
        this.byteArray = jsonArray.toString().getBytes();
    }

    /**
     * Method to prepare request body from HashMap
     *
     * @param hashMap HashMap
     */
    public void fromHashMap(HashMap<String, String> hashMap) {
        this.byteArray = new JSONObject(hashMap).toString().getBytes();
    }

    /**
     * Method to get the request body as a byte array
     *
     * @return byte array
     */
    public byte[] getBytes() {
        if (this.byteArray == null) {
            return new byte[0];
        }
        else {
            return this.byteArray;
        }
    }
}

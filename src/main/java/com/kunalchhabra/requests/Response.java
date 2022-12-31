package com.kunalchhabra.requests;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Response {
    private final int statusCode;
    private final byte[] byteData;
    private final ResponseHeader headers;

    protected Response(int statusCode, byte[] byteData, ResponseHeader headers) {
        this.statusCode = statusCode;
        this.byteData = byteData;
        this.headers = headers;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
    public ResponseHeader getHeaders() {
        return this.headers;
    }

    public String toString() {
        return new String(this.byteData, StandardCharsets.UTF_8);
    }

    public String toText() {
        return this.toString();
    }

    public JSONObject toJsonObject() {
        return new JSONObject(this.toString());
    }

    public JSONArray toJsonArray() {
        return new JSONArray(this.toString());
    }

    public byte[] toBytes() {
        return this.byteData;
    }

    public String toBase64() {
        return Base64.getEncoder().encodeToString(this.toBytes());
    }

    public void toFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.write(path, this.toBytes());
    }

    public Hash toHash() {
        return new Hash(this.toBytes());
    }
}
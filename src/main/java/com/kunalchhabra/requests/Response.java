package com.kunalchhabra.requests;

import org.json.JSONArray;
import org.json.JSONObject;

public class Response {
    private final int statusCode;
    private final String data;

    public Response(int statusCode, String data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return this.data;
    }

    public String text() {
        return this.data;
    }

    public JSONObject toJsonObject() {
        return new JSONObject(this.data);
    }

    public JSONArray toJsonArray() {
        return new JSONArray(this.data);
    }
}

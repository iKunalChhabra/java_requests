package com.kunalchhabra.requests;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * JsonParser class
 */
public class JsonParser{
    private final Object json;
    private Object parsed;

    /**
     * Constructor for JsonParser class
     * @param json json
     */
    public JsonParser(Object json) {
        this.json = json;
    }
    /**
     * Get array index
     * @param part part
     * @return int
     */
    private int getArrayIndex(String part) {
        String[] arr = part.split("\\[");
        String strIndex = arr[1].replace("]", "");
        return Integer.parseInt(strIndex.strip());
    }

    /**
     * Get json value
     * @param exp exp
     * @return JsonParser
     */
    public JsonParser get(String exp) {

        String[] parts = exp.split("->");
        parsed = json;

        for (String part : parts) {
            if (part.strip().startsWith("[")) {
                int index = getArrayIndex(part);
                this.parsed = ((JSONArray) this.parsed).get(index);
            }
            else {
                this.parsed = ((JSONObject) this.parsed).get(part);
            }
        }
        return this;
    }

    /**
     * Get parsed value as int
     * @return int
     */
    public int toInt() {
        return Integer.parseInt(this.toString());
    }

    /**
     * Get parsed value as double
     * @return double
     */
    public double toDouble() {
        return Double.parseDouble(this.toString());
    }

    /**
     * Get parsed value as string
     * @return String
     */
    public String toString() {
        return this.parsed.toString();
    }

    /**
     * Get parsed value as boolean
     * @return boolean
     */
    public boolean toBoolean() {
        return Boolean.parseBoolean(this.toString());
    }
}

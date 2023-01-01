package com.kunalchhabra.requests;
import java.util.HashMap;

/**
 * Abstract class for storing properties.
 */
public abstract class Properties extends HashMap<String, String>{

    /**
     * Set a property.
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        this.put(key, value);
    }
}

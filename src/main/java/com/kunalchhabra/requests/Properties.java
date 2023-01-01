package com.kunalchhabra.requests;
import java.util.HashMap;

/**
 * Abstract class for storing properties.
 */
public abstract class Properties extends HashMap<String, String>{

    /**
     * Constructor for Properties class
     */
    public Properties() {
        super();
    }

    /**
     * Set a property.
     * @param key Key of the property
     * @param value Value of the property
     */
    public void set(String key, String value) {
        this.put(key, value);
    }
}

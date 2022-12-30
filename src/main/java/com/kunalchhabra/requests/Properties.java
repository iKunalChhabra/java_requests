package com.kunalchhabra.requests;
import java.util.HashMap;

public abstract class Properties extends HashMap<String, String>{
    public void set(String key, String value) {
        this.put(key, value);
    }
}

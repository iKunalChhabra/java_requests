package com.kunalchhabra.requests;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to store Response Headers like Content-Type, Content-Length, etc.
 * It extends HashMap
 */
public class ResponseHeader extends HashMap<String, List<String>> {

    /**
     * Get the value of a header
     * @param key the header name
     * @return the value of the header as List of Strings
     */
    public ResponseHeader(Map<String, List<String>> map) {
        super(map);
    }
}


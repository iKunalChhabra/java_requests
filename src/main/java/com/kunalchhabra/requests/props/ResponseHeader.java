package com.kunalchhabra.requests.props;

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
     * @param map Map of headers
     */
    public ResponseHeader(Map<String, List<String>> map) {
        super(map);
    }
}


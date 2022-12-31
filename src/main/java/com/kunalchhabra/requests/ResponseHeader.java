package com.kunalchhabra.requests;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ResponseHeader extends HashMap<String, List<String>> {
    public ResponseHeader() {
        super();
    }
    public ResponseHeader(Map<String, List<String>> map) {
        super(map);
    }
}


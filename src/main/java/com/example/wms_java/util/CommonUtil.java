package com.example.wms_java.util;

import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

    public static Map apiResult(Object status, Object value) {
        Map map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("value", value);
        return map;
    }
}

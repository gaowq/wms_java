package com.example.wms_java.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {

    public static Map apiResult(Object status, Object value) {
        Map map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("value", value);
        return map;
    }

    public static Map getDataTable(List<?> list) {
        //TableDataInfo rspData = new TableDataInfo();
        Map map = new HashMap<String, Object>();
        map.put("status", 1);
        map.put("rows", list);
        map.put("total",(new PageInfo(list)).getTotal());
//        rspData.setMsg("查询成功");
//        rspData.setCode(200);
//        rspData.setRows(list);
//        rspData.setTotal((new PageInfo(list)).getTotal());
        return map;
    }
}

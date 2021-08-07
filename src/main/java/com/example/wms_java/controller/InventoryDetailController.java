package com.example.wms_java.controller;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import com.example.wms_java.service.impl.InventoryDetailService;
import com.example.wms_java.service.impl.InventoryService;
import com.example.wms_java.util.CommonConstant;
import com.example.wms_java.util.CommonUtil;
import com.example.wms_java.util.ExcelUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/inventoryDetail")
public class InventoryDetailController {
    @Autowired
    private InventoryDetailService inventoryDetailService;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        return "/inventory/index";
    }

    @GetMapping("/detail")
    public String detail(HttpServletRequest request) {
        return "inventory/detail";
    }

    @ResponseBody
    @PostMapping("/getList")
    public Map getList(InventoryDetail inventoryDetail) {
        PageHelper.startPage(inventoryDetail.getPage(), inventoryDetail.getRows(), inventoryDetail.getOrderBy());
        return CommonUtil.getDataTable(inventoryDetailService.selectList(inventoryDetail));
    }

    @ResponseBody
    @PostMapping("/addIn")
    public Map addIn(@RequestBody InventoryDetail inventoryDetail) {
        inventoryDetail.setType(CommonConstant.INVENTORY_DETAIL_IN);
        int result = inventoryDetailService.insertInventoryDetail(inventoryDetail);
        return CommonUtil.apiResult(result, "");
    }

    @ResponseBody
    @PostMapping("/addOut")
    public Map addOut(@RequestBody InventoryDetail inventoryDetail) {
        inventoryDetail.setType(CommonConstant.INVENTORY_DETAIL_OUT);
        int result = inventoryDetailService.insertInventoryDetail(inventoryDetail);
        return CommonUtil.apiResult(result, "");
    }

    @ResponseBody
    @PostMapping("/delete")
    public Map delete(@RequestBody InventoryDetail inventoryDetail) {
        int result = inventoryDetailService.deleteById(inventoryDetail.getId());
        return CommonUtil.apiResult(result, "");
    }

    @ResponseBody
    @RequestMapping("/export")
    public void exportSysUsers(HttpServletRequest req, HttpServletResponse res,
                               String type, String createDate) throws IOException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatTime = sdf.format(d);
        String fileName = "系统用户表-" + formatTime;
        //填充projects数据
        InventoryDetail inventoryDetail = new InventoryDetail();

        if (type != null && type != "") {
            inventoryDetail.setType(Integer.parseInt(type));
        }

        inventoryDetail.setCreateDate(createDate);
        List<InventoryDetail> inventoryDetailList = inventoryDetailService.selectList(inventoryDetail);
        List<Map<String, Object>> list = createExcelRecord(inventoryDetailList);
        String columnNames[] = {"名称", "规格", "数量", "价格", "类型", "时间"};
        String keys[] = {"inventoryName", "inventorySpec", "qty", "price", "type", "createTime"};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        res.reset();
        res.setContentType("application/vnd.ms-excel;charset=utf-8");
        res.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = res.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
    }

    /**
     * 生成Excel数据
     *
     * @param userList
     * @return
     */
    private List<Map<String, Object>> createExcelRecord(List<InventoryDetail> userList) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        InventoryDetail inventoryDetail = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        for (int j = 0; j < userList.size(); j++) {
            inventoryDetail = userList.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
            //String keys[] = {"inventoryName", "inventorySpec", "qty", "price", "type", "createTime"};
            mapValue.put("inventoryName", inventoryDetail.getInventoryName());
            mapValue.put("inventorySpec", inventoryDetail.getInventorySpec());
            mapValue.put("qty", inventoryDetail.getQty());
            mapValue.put("price", inventoryDetail.getPrice());
            mapValue.put("type", inventoryDetail.getType() == CommonConstant.INVENTORY_DETAIL_IN ? "入库" : "出库");
            mapValue.put("createTime", sdf.format(inventoryDetail.getCreateTime()));
            listmap.add(mapValue);
        }
        return listmap;
    }
}

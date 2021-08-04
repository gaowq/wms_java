package com.example.wms_java.controller;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import com.example.wms_java.service.impl.InventoryDetailService;
import com.example.wms_java.service.impl.InventoryService;
import com.example.wms_java.util.CommonConstant;
import com.example.wms_java.util.CommonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
@RequestMapping("/inventoryDetail")
public class InventoryDetailController {
    @Autowired
    private InventoryDetailService inventoryDetailService;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        //request.setAttribute("key", "游客");
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
}

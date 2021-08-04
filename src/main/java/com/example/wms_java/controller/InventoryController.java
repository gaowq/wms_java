package com.example.wms_java.controller;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import com.example.wms_java.service.impl.InventoryService;
import com.example.wms_java.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        //request.setAttribute("key", "游客");
        return "inventory/index";
    }

    @GetMapping("/detail")
    public String detail(HttpServletRequest request) {
        return "/inventory/detail";
    }

    @ResponseBody
    @PostMapping("/getList")
    public List<Inventory> getTable3(Inventory inventory) {
        PageHelper.startPage(inventory.getPage(), inventory.getRows(), inventory.getOrderBy());
        return inventoryService.selectList(inventory);
    }

    @ResponseBody
    @PostMapping("/add")
    public Map add(@RequestBody Inventory inventory) {
        inventory.setCreateTime(new Date());
        int result = inventoryService.insertInventory(inventory);
        return CommonUtil.apiResult(result, "");
    }


    @ResponseBody
    @PostMapping("/delete")
    public Map delete(@RequestBody Inventory inventory) {
        int result = inventoryService.deleteInventoryById(inventory.getId());
        return CommonUtil.apiResult(result, "");
    }
}

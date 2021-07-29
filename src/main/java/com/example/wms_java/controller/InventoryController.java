package com.example.wms_java.controller;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.service.impl.InventoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/index")
    public String my2(HttpServletRequest request) {
        //request.setAttribute("key", "游客");
        return "/inventory/index";
    }

    @ResponseBody
    @PostMapping("/getList")
    public List<Inventory> getTable3(Inventory inventory) {
        PageHelper.startPage(inventory.getPage(), inventory.getRows(), inventory.getOrderBy());
        return inventoryService.selectList(inventory);
    }
}

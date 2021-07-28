package com.example.wms_java.controller;

import com.example.wms_java.model.Classify;
import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.Menu;
import com.example.wms_java.service.IClassifyService;
import com.example.wms_java.service.impl.ClassifyService;
import com.example.wms_java.service.impl.InventoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private InventoryService inventoryService;

//    @ResponseBody
//    @PostMapping("/getTable1")
//    public Map getTable1(@RequestParam("xSize") Integer xSize, @RequestParam("ySize") Integer ySize, @RequestParam("zeroX") Integer zeroX, @RequestParam("zeroY") Integer zeroY, @RequestParam("depth") Integer depth) {
//        int coordinate3d = depth * 10000 + zeroY * 100 + zeroX;
//        return Util.ReturnResult(1, "", "");
//    }

    @GetMapping("/")
    public String my(HttpServletRequest request) {
        request.setAttribute("key", "游客");
        return "/index";
    }

    @GetMapping("/aaa2")
    public String my2(HttpServletRequest request) {
        request.setAttribute("key", "游客");
        return "/index2";
    }

    @ResponseBody
    @PostMapping("/getTable2")
    public List<Inventory> getTable2(Inventory inventory) {
//        if (inventory == null) {
//            inventory = new Inventory();
//        }
//        inventory.setPageNum(1);
//        inventory.setPageSize(10);
        List<Inventory> aa = inventoryService.selectList(inventory);
        return inventoryService.selectList(inventory);
    }

    @ResponseBody
    @PostMapping("/getTable3")
    public List<Inventory> getTable3(Inventory inventory) {
        PageHelper.startPage(inventory.getPage(), inventory.getRows(), inventory.getOrderBy());
        return inventoryService.selectList(inventory);
    }


    @ResponseBody
    @PostMapping("/getTable4")
    public Menu[] getTable4() {

        Menu menu1 = new Menu();
        menu1.setText("aaa测试");
        menu1.setUrl("/abc/a1");


        Menu menu2 = new Menu();
        menu2.setText("aaa测试2");
        menu2.setUrl("/abc/a2");

        Menu menu3 = new Menu();
        menu3.setText("aaa测试2");
        menu3.setUrl("/aaa2");

        menu2.setChildren(new Menu[]{menu3});

        Menu[] menus = new Menu[]{menu1, menu2};

        return menus;
    }
}

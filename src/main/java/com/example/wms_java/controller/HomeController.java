package com.example.wms_java.controller;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.MyMenu;
import com.example.wms_java.service.impl.ClassifyService;
import com.example.wms_java.service.impl.InventoryService;
import com.example.wms_java.service.impl.MyMenuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private MyMenuService myMenuService;

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
    public MyMenu[] getTable4() {

//        MyMenu myMenu1 = new MyMenu();
//        myMenu1.setText("aaa测试");
//        myMenu1.setUrl("/abc/a1");
//
//
//        MyMenu myMenu2 = new MyMenu();
//        myMenu2.setText("aaa测试2");
//        myMenu2.setUrl("/abc/a2");
//
//        MyMenu myMenu3 = new MyMenu();
//        myMenu3.setText("aaa测试2");
//        myMenu3.setUrl("/inventory/index");
//
//        myMenu2.setChildren(new MyMenu[]{myMenu3});
//
//        MyMenu[] myMenus = new MyMenu[]{myMenu1, myMenu2};

        List<MyMenu> menus = myMenuService.selectList();
        return menus.toArray(new MyMenu[menus.size()]);
    }
}

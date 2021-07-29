package com.example.wms_java.service.impl;

import com.example.wms_java.mapper.ClassifyMapper;
import com.example.wms_java.mapper.MyMenuMapper;
import com.example.wms_java.model.Classify;
import com.example.wms_java.model.MyMenu;
import com.example.wms_java.service.IClassifyService;
import com.example.wms_java.service.IMyMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyMenuService implements IMyMenuService {
    @Autowired
    private MyMenuMapper myMenuMapper;

    @Override
    public List<MyMenu> selectList() {
        List<MyMenu> oldList = myMenuMapper.selectList();
        List<MyMenu> newList = new ArrayList<>();

        for (MyMenu myMenu : oldList) {
            if (myMenu.getParentId() == 0) {
                newList.add(myMenu);
            } else {
                MyMenu parentMenu = oldList.stream().filter(q -> q.getId().equals(myMenu.getParentId())).findFirst().orElse(null);

                if (parentMenu != null) {
                    parentMenu.addChildren(myMenu);
                }
            }
        }

        for(MyMenu myMenu :newList)
        {
            myMenu.refreshChildren();
        }

        return newList;
    }

}

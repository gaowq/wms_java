package com.example.wms_java.service;

import com.example.wms_java.model.Classify;
import com.example.wms_java.model.MyMenu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IMyMenuService {

    List<MyMenu> selectList();

}

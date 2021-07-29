package com.example.wms_java.mapper;

import com.example.wms_java.model.MyMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMenuMapper {

    List<MyMenu> selectList();
}

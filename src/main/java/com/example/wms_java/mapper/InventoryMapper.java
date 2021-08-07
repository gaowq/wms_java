package com.example.wms_java.mapper;

import com.example.wms_java.model.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InventoryMapper {
    List<Inventory> selectList(Inventory inventory);

    int deleteByPrimaryKey(Integer id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inventory record);

    int updateInventory(Inventory record);

    int addInventory(@Param("id") Integer inventoryId, @Param("quantity") int qty);

    int minusInventory(@Param("id") Integer inventoryId, @Param("quantity") int qty);
}

package com.example.wms_java.mapper;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryDetailMapper {

    List<InventoryDetail> selectList(InventoryDetail record);

    int insertInventoryDetail(InventoryDetail record);

    int updateInventoryDetail(InventoryDetail record);

    int deleteById(Integer id);
}

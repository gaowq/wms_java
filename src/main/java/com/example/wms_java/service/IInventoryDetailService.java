package com.example.wms_java.service;

import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IInventoryDetailService {

    int insertInventoryDetail(InventoryDetail inventoryDetail);

    int updateInventoryDetail(InventoryDetail inventoryDetail);

    List<InventoryDetail> selectList(InventoryDetail inventoryDetail);

    int deleteById(int id);
}

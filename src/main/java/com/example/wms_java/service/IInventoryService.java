package com.example.wms_java.service;

import com.example.wms_java.model.Classify;
import com.example.wms_java.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IInventoryService {

    int insertInventory(Inventory inventory);

    int updateInventory(Inventory inventory);

    List<Inventory> selectList(Inventory inventory);

    int deleteInventoryById(int id);
}

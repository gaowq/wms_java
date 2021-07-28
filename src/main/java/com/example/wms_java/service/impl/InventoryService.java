package com.example.wms_java.service.impl;

import com.example.wms_java.mapper.ClassifyMapper;
import com.example.wms_java.mapper.InventoryMapper;
import com.example.wms_java.model.Classify;
import com.example.wms_java.model.Inventory;
import com.example.wms_java.service.IClassifyService;
import com.example.wms_java.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public int insertInventory(Inventory inventory) {
        return inventoryMapper.insert(inventory);
    }

    @Override
    public int updateInventory(Inventory inventory) {
        return inventoryMapper.updateByPrimaryKey(inventory);
    }

    @Override
    public List<Inventory> selectList(Inventory inventory) {
        return inventoryMapper.selectList(inventory);
    }

    @Override
    public int deleteInventoryById(int id) {
        return inventoryMapper.deleteByPrimaryKey(id);
    }
}

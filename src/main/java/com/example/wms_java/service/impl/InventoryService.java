package com.example.wms_java.service.impl;

import com.example.wms_java.mapper.ClassifyMapper;
import com.example.wms_java.mapper.InventoryDetailMapper;
import com.example.wms_java.mapper.InventoryMapper;
import com.example.wms_java.model.Classify;
import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import com.example.wms_java.service.IClassifyService;
import com.example.wms_java.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private InventoryDetailMapper inventoryDetailMapper;

    @Override
    public int insertInventory(Inventory inventory) {
        return inventoryMapper.insert(inventory);
    }

    @Override
    public int updateInventory(Inventory inventory) {
        return inventoryMapper.updateInventory(inventory);
    }

    @Override
    public List<Inventory> selectList(Inventory inventory) {
        List<Inventory> list = inventoryMapper.selectList(inventory);

        for (Inventory item : list) {
            InventoryDetail inventoryDetailIn = inventoryDetailMapper.selectLatestIn(item.getId());

            if (inventoryDetailIn != null && inventoryDetailIn.getPrice() != null) {
                item.setLastInPrice(inventoryDetailIn.getPrice());
            }

            InventoryDetail inventoryDetailOut = inventoryDetailMapper.selectLatestOut(item.getId());

            if (inventoryDetailOut != null && inventoryDetailOut.getPrice() != null) {
                item.setLastOutPrice(inventoryDetailOut.getPrice());
            }
        }
        return list;
    }

    @Override
    public int deleteInventoryById(int id) {
        return inventoryMapper.deleteByPrimaryKey(id);
    }
}

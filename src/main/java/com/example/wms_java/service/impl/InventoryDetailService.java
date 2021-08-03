package com.example.wms_java.service.impl;

import com.example.wms_java.mapper.InventoryDetailMapper;
import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import com.example.wms_java.service.IInventoryDetailService;
import com.example.wms_java.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryDetailService implements IInventoryDetailService {
    @Autowired
    private InventoryDetailMapper inventoryDetailMapper;

    @Override
    public int insertInventoryDetail(InventoryDetail inventoryDetail) {
        return inventoryDetailMapper.insertInventoryDetail(inventoryDetail);
    }

    @Override
    public int updateInventoryDetail(InventoryDetail inventoryDetail) {
        return inventoryDetailMapper.updateInventoryDetail(inventoryDetail);
    }

    @Override
    public List<InventoryDetail> selectList(InventoryDetail inventoryDetail) {
        return inventoryDetailMapper.selectList(inventoryDetail);
    }

    @Override
    public int deleteById(int id) {
        return inventoryDetailMapper.deleteById(id);
    }
}

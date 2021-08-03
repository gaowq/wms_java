package com.example.wms_java.service.impl;

import com.example.wms_java.mapper.InventoryDetailMapper;
import com.example.wms_java.mapper.InventoryMapper;
import com.example.wms_java.model.Inventory;
import com.example.wms_java.model.InventoryDetail;
import com.example.wms_java.service.IInventoryDetailService;
import com.example.wms_java.service.IInventoryService;
import com.example.wms_java.util.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class InventoryDetailService implements IInventoryDetailService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private InventoryDetailMapper inventoryDetailMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertInventoryDetail(InventoryDetail inventoryDetail) {

        int result;
        int result2;

        if (inventoryDetail.getInventoryId() == null || inventoryDetail.getInventoryId() == null) {
            return 0;
        }

        if (inventoryDetail.getType() == CommonConstant.INVENTORY_DETAIL_IN) {
            result = inventoryMapper.addInventory(inventoryDetail.getInventoryId(), inventoryDetail.getQty());
        } else if (inventoryDetail.getType() == CommonConstant.INVENTORY_DETAIL_OUT) {
            result = inventoryMapper.minusInventory(inventoryDetail.getInventoryId(), inventoryDetail.getQty());
        } else {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

        if (result == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        } else {
            result2 = inventoryDetailMapper.insertInventoryDetail(inventoryDetail);

            if (result2 == 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return 0;
            }
        }
        return result2;
    }

    @Transactional(rollbackFor = Exception.class)
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

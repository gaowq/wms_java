package com.example.wms_java.model;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.stereotype.Repository;

/**
 * inventory
 * @author
 */
@Repository
public class Inventory extends MyPage {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    /**
     * 规格型号
     */
    private String spec;

    /**
     * 数量
     */
    private Integer qty;

    /**
     * 存放位置
     */
    private String location;

    /**
     * 最低库存数量
     */
    private Integer minQty;

    private Integer isdel;

    private Date createTime;

    private Integer createId;

    private Date updateTime;

    private Integer updateId;

    private Integer isNeedAdd;

    private BigDecimal lastInPrice;

    private BigDecimal lastOutPrice;

    public Integer getIsNeedAdd() {
        return isNeedAdd;
    }

    public void setIsNeedAdd(Integer isNeedAdd) {
        this.isNeedAdd = isNeedAdd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMinQty() {
        return minQty;
    }

    public void setMinQty(Integer minQty) {
        this.minQty = minQty;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public BigDecimal getLastInPrice() {
        return lastInPrice;
    }

    public void setLastInPrice(BigDecimal lastInPrice) {
        this.lastInPrice = lastInPrice;
    }

    public BigDecimal getLastOutPrice() {
        return lastOutPrice;
    }

    public void setLastOutPrice(BigDecimal lastOutPrice) {
        this.lastOutPrice = lastOutPrice;
    }
}

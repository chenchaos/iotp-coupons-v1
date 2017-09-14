/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.dto;

import io.springbootstrap.core.dto.IdDto;

import java.util.Date;

/**
 * CouponDto
 *
 * @author wuhaohang
 * @since 2.0.0
 */
public class CouponDto extends IdDto{
    private String name;                                     // 优惠券名称
    private String type;                                     // 优惠券类型
    private String useCondition;                             // 使用条件
    private String discountType;                             // 折扣类型
    private int amount;                                      // 金额
    private int minCheck;                                    // 最低消费金额
    private int discount;                                    // 折扣百分比
    private int maxDiscountAmount;                           // 最大折扣金额
    private Long validityDate;                               // 生效时间
    private Long expiryDate;                                 // 失效时间
    private int maxCouponCount;                              // 最大发行量
    private String description;                              // 优惠券说明
    private int receiveNum;                                  // 领取人数
    private int useNum;                                      // 使用人数
    private Long created;                                    // 创建时间
    private Long modified;                                   // 最后修改时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(String useCondition) {
        this.useCondition = useCondition;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinCheck() {
        return minCheck;
    }

    public void setMinCheck(int minCheck) {
        this.minCheck = minCheck;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public void setMaxDiscountAmount(int maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public Long getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Long validityDate) {
        this.validityDate = validityDate;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getMaxCouponCount() {
        return maxCouponCount;
    }

    public void setMaxCouponCount(int maxCouponCount) {
        this.maxCouponCount = maxCouponCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReceiveNum() {
        return receiveNum;
    }

    public void setReceiveNum(int receiveNum) {
        this.receiveNum = receiveNum;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getModified() {
        return modified;
    }

    public void setModified(Long modified) {
        this.modified = modified;
    }
}
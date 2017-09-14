/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-06
 */
package io.iotp.coupons.dto;

import io.iotp.coupons.entity.Coupon;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * CouponForm
 *
 * @author wuhaohang
 * @since 2.0.0
 */
@ApiModel(value = "CouponForm",description = "优惠券请求数据对象")
public class CouponForm {
    @ApiModelProperty(notes = "优惠券名称",required = true)
    private String name;                                     // 优惠券名称
    @ApiModelProperty(notes = "优惠券类型 ：全部商品-' ' 多个商品用'，'隔开",required = true)
    private String type;                                     // 优惠券类型
    @ApiModelProperty(notes = "使用条件")
    private String useCondition;                             // 使用条件
    @ApiModelProperty(notes = "折扣类型 MJ-满减 ZK-折扣")
    private String discountType;                             // 折扣类型
    @ApiModelProperty(notes = "金额 满减类型时必输")
    private int amount;                                      // 金额
    @ApiModelProperty(notes = "最低消费金额")
    private int minCheck;                                    // 最低消费金额
    @ApiModelProperty(notes = "折扣百分比 折扣类型时必输")
    private int discount;                                    // 折扣百分比
    @ApiModelProperty(notes = "最大折扣金额 折扣类型时必输")
    private int maxDiscountAmount;                           // 最大折扣金额
    @ApiModelProperty(notes = "生效时间",required = true)
    private Long validityDate;                               // 生效时间
    @ApiModelProperty(notes = "失效时间",required = true)
    private Long expiryDate;                                 // 失效时间
    @ApiModelProperty(notes = "最大发行量",required = true)
    private int maxCouponCount;                              // 最大发行量
    @ApiModelProperty(notes = "优惠券说明")
    private String description;                              // 优惠券说明

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
}
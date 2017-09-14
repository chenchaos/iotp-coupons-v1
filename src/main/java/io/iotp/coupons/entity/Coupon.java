/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.entity;

import io.springbootstrap.core.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 优惠券模板表
 *
 * @author wuhaohang
 * @since 2.0.0
 */
@Entity
@Table(name = "tbCoupon")
public class Coupon extends IdEntity{

    /**
     * 优惠券状态:正常，值：{@value}
     */
    public static final int ST_ENABLE = 0;
    /**
     * 优惠券状态：失效，值：{@value}
     */
    public static final int ST_DISABLE = 9;
    /**
     * 优惠券类型：无限制
     */
    public static final String TYPE_NONE = "";
    /**
     * 优惠券折扣类型：满减，值：{@value}
     */
    public static final String DISCOUNT_MJ = "MJ";
    /**
     * 优惠券折扣类型：打折，值：{@value}
     */
    public static final String DISCOUNT_ZK = "ZK";

    private Long shopId;                                     // 所属店铺
    private int status;                                      // 优惠券状态
    private String name;                                     // 优惠券名称
    private String type;                                     // 优惠券类型
    private String useCondition;                             // 使用条件
    private String discountType;                             // 折扣类型
    private int amount;                                      // 金额
    private int minCheck;                                    // 最低消费金额
    private int discount;                                    // 折扣百分比
    private int maxDiscountAmount;                           // 最大折扣金额
    private Date validityDate;                               // 生效时间
    private Date expiryDate;                                 // 失效时间
    private int maxCouponCount;                              // 最大发行量
    private String description;                              // 优惠券说明
    private Date created;                                    // 创建时间
    private Date modified;                                   // 最后修改时间

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
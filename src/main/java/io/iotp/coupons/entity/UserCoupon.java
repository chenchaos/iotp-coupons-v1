/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.entity;

import io.springbootstrap.core.entity.IdEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 用户优惠券信息表
 *
 * @author wuhaohang
 * @since 2.0.0
 */
@Entity
@Table(name = "tbUser_Coupon")
public class UserCoupon extends IdEntity{
    /**
     * 状态:可使用，值：{@value}
     */
    public static final int ST_ENABLE = 0;
    /**
     * 状态：已使用，值：{@value}
     */
    public static final int ST_DISABLE = 9;
    /**
     * 领取方式：直接领取，值：{@value}
     */
    public static final int OT_DIRECT = 0;
    /**
     * 领取方式：优惠码兑换，值：{@value}
     */
    public static final int OT_EXCHANGE = 1;


    private Long userId;                                          // 所属用户
    private Long shopId;                                          // 所属店铺
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;                                        // 所属优惠券
    private int status;                                           // 状态
    private int obtainedType;                                     // 获取方式
    private Date obtainedAt;                                      // 获取时间
    private Date userAt;                                          // 使用时间
    private Long orderId;                                         // 所属订单
    private String orderSubject;                                  // 订单标题
    private Date created;                                         // 创建时间
    private Date modified;                                        // 修改时间

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getObtainedType() {
        return obtainedType;
    }

    public void setObtainedType(int obtainedType) {
        this.obtainedType = obtainedType;
    }

    public Date getObtainedAt() {
        return obtainedAt;
    }

    public void setObtainedAt(Date obtainedAt) {
        this.obtainedAt = obtainedAt;
    }

    public Date getUserAt() {
        return userAt;
    }

    public void setUserAt(Date userAt) {
        this.userAt = userAt;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderSubject() {
        return orderSubject;
    }

    public void setOrderSubject(String orderSubject) {
        this.orderSubject = orderSubject;
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
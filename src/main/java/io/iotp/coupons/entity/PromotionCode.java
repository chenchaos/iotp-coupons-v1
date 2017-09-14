package io.iotp.coupons.entity;

import io.springbootstrap.core.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tbPromotion_Code")
public class PromotionCode extends IdEntity {
    private int    parentId;                             //优惠码id
    private String code;                                 //优惠码
    private String userId;                               //兑换用户id
    private Date   exchangedAt;                          //兑换时间



    public int getParentId() {return parentId; }
    public String getCode() { return code;}
    public String getUserId() {
        return userId;
    }
    public Date getExchangedAt() {
        return exchangedAt;
    }





    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setExchangedAt(Date exchangedAt) {
        this.exchangedAt = exchangedAt;
    }
}

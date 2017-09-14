package io.iotp.coupons.entity;

import io.springbootstrap.core.entity.IdEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbPromotion_Form")
public class PromotionForm extends IdEntity {

     private  int    shopId;                                      //所属店铺
     private  int    status;                                      //优惠码状态
     private  int    couponId;                                   //相应优惠卷id
     private  String name;                                        //优惠码名称
     private  String type;                                        //优惠码类型
     private  String code;                                        //通用优惠码
     private  Date   validityDate;                               //生效时间
     private  Date   expiryDate;                                 //失效时间
     private  String description;                                 //优惠码说明
     private  Date   created;                                     //创建日期
     private  Date   modified;                                    //最后修改日期

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
     private List<PromotionCode> promotionCodeList;               //此优惠信息下的所有优惠码

    public int getShopId() {
        return shopId;
    }
    public int getStatus() {
        return status;
    }
    public int getCouponId() {
        return couponId;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getCode() {
        return code;
    }
    public Date getValidityDate() {
        return validityDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public String getDescription() {
        return description;
    }
    public Date getCreated() {
        return created;
    }
    public Date getModified() {
        return modified;
    }
    public List<PromotionCode> getPromotionCodeList() {
        return promotionCodeList;
    }




    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
    public void setPromotionCodeList(List<PromotionCode> promotionCodeList) {
        this.promotionCodeList = promotionCodeList;
    }
}

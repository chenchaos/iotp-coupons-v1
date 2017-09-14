package io.iotp.coupons.dto;

import io.springbootstrap.core.dto.IdDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


public class PromotionFormDto extends IdDto {

     private  String    shopId;                                    //所属店铺
     private  int    status;                                       //优惠码状态
     private  int    couponId;                                     //相应优惠卷id
     private  String name;                                         //优惠码名称
     private  String type;                                         //优惠码类型 (WY:唯一码  TY:通用码）
     private  String code;                                         //通用优惠码
     private  Long   validityDate;                                 //生效时间
     private  Long   expiryDate;                                   //失效时间
     private  String description;                                  //优惠码说明
     private  Long   created;                                      //创建日期
     private  Long   modified;                                     //最后修改日期
     private  String promotionType;                                //唯一码或者通用码


    public String getShopId() {
        return shopId;
    }
    public int getStatus() {
        return status;
    }
    public int getCouponId() { return couponId; }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getCode() {
        return code;
    }
    public Long getValidityDate() {
        return validityDate;
    }
    public Long getExpiryDate() {
        return expiryDate;
    }
    public String getDescription() {
        return description;
    }
    public Long getCreated() {
        return created;
    }
    public Long getModified() {
        return modified;
    }
    public String getPromotionType() { return promotionType; }




    public void setShopId(String shopId) {
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
    public void setValidityDate(Long validityDate) {
        this.validityDate = validityDate;
    }
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreated(Long created) {
        this.created = created;
    }
    public void setModified(Long modified) {
        this.modified = modified;
    }
    public void setPromotionType(String promotionType) {this.promotionType = promotionType; }
}

package io.iotp.coupons.dto;

import io.springbootstrap.core.dto.IdDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "PromotionForm",description = "优惠码请求数据对象")
public class PromotionForms extends IdDto {
    @ApiModelProperty(notes = "所属店铺 （新增需要传，更新不需要传）",required = true)
     private  String    shopId;                                      //所属店铺
    @ApiModelProperty(notes = "相应优惠卷id（新增需要传，更新不需要传）",required = true)
     private  String    couponId;                                   //相应优惠卷id
    @ApiModelProperty(notes = "优惠码名称",required = true)
     private  String name;                                        //优惠码名称
    @ApiModelProperty(notes = "优惠码类型（WY:唯一码  TY:通用码）（新增需要传，更新不需要传）",required = true)
     private  String type;                                        //优惠码类型
    @ApiModelProperty(notes = "生效时间",required = true)
     private  Date   validityDate;                               //生效时间
    @ApiModelProperty(notes = "失效时间",required = true)
     private  Date   expiryDate;                                 //失效时间
    @ApiModelProperty(notes = "优惠码说明",required = true)
     private  String description;                                 //优惠码说明




    public String getShopId() {
        return shopId;
    }
    public String getCouponId() {
        return couponId;
    }
    public String getName() {
        return name;
    }
    public String getType() { return type; }
    public Date getValidityDate() {
        return validityDate;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public String getDescription() {
        return description;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
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


}

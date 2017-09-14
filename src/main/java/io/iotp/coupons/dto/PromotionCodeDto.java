package io.iotp.coupons.dto;

import io.springbootstrap.core.dto.IdDto;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class PromotionCodeDto extends IdDto {
    private String   parentId;                             //优惠码id
    private String   code;                                 //优惠码
    private String   userId;                               //兑换用户id
    private Long     exchangedAt;                          //兑换时间
    private String   userName;                             //用户名称
    private boolean  tailored;                             //是否已领取

    public String  getParentId() {
        return parentId;
    }
    public String  getCode() {
        return code;
    }
    public String  getUserId() {
        return userId;
    }
    public Long    getExchangedAt() {
        return exchangedAt;
    }
    public String  getUserName() { return userName; }
    public boolean isTailored() {return tailored; }

    public void setUserName(String userName) {this.userName = userName; }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setExchangedAt(Long exchangedAt) {
        this.exchangedAt = exchangedAt;
    }
    public void setTailored(boolean tailored) {this.tailored = tailored; }
}

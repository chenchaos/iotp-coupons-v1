package io.iotp.coupons.service;

import io.iotp.coupons.entity.PromotionCode;
import io.iotp.coupons.entity.PromotionForm;
import io.springbootstrap.core.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PromotionCodeService extends SimpleService<PromotionCode>{

    public Page<PromotionCode> getPromotionList(long id, Pageable pageable, String searchPhrase);//此优惠码模版下的所有优惠码
    public Page<PromotionCode> getPromotionListOrder(long id,Pageable pageable,String searchPhrase);//此优惠码模版下的已领取过的优惠码
    public Page<PromotionCode> getPromotionListUnfinished(long id,Pageable pageable,String searchPhrase);//此优惠码模版下的未领取过的优惠码
    public String getUserName(long userId);                         //获取用户名称
    public List<PromotionCode> getByPromotionFormId(long id);       //通过优惠码模版id获取优惠码
    public String getPromotionFormName(long id);                   //通过id获取优惠码模版名称
    public int getMaxId();                                          //获取优惠码最大id

}

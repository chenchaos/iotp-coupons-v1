package io.iotp.coupons.service;

import io.iotp.coupons.dto.PromotionFormDto;
import io.iotp.coupons.entity.PromotionForm;
import io.springbootstrap.core.service.AbstractEntityDtoMapper;
import io.springbootstrap.core.util.IdConfuseUtils;
import org.springframework.stereotype.Component;

@Component
public class PromotionFormEntityDtoMapper extends AbstractEntityDtoMapper<PromotionForm,PromotionFormDto> {
    public void additionalMap(PromotionForm promotionForm,PromotionFormDto promotionFormDto){
       String type ="";
       if(promotionForm.getCode()!=null){
           type="通用码";
       }else{
           type="唯一码";
       }
       promotionFormDto.setPromotionType(type);
       promotionFormDto.setShopId(IdConfuseUtils.encodeId((long)promotionForm.getShopId()));
       if(promotionForm.getValidityDate()!=null){
           promotionFormDto.setValidityDate(promotionForm.getValidityDate().getTime());
       }
       if(promotionForm.getExpiryDate()!=null){
           promotionFormDto.setExpiryDate(promotionForm.getExpiryDate().getTime());
       }
       if(promotionForm.getCreated()!=null){
           promotionFormDto.setCreated(promotionForm.getCreated().getTime());
       }
       if(promotionForm.getModified()!=null){
           promotionFormDto.setModified(promotionForm.getModified().getTime());
       }
    }
}

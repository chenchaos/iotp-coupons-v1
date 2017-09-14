package io.iotp.coupons.service;

import io.iotp.coupons.dto.PromotionCodeDto;
import io.iotp.coupons.entity.PromotionCode;
import io.springbootstrap.core.service.AbstractEntityDtoMapper;
import io.springbootstrap.core.util.IdConfuseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromotionCodeEntityDtoMapper extends AbstractEntityDtoMapper<PromotionCode,PromotionCodeDto> {
    @Autowired
    PromotionCodeService promotionCodeService;
    public void additionalMap(PromotionCode promotionCode,PromotionCodeDto promotionCodeDto){
        String userId  =promotionCode.getUserId();
        if(userId!=null) {
            String userName = promotionCodeService.getUserName(Long.parseLong(userId));
            promotionCodeDto.setUserName(userName);
        }
        if(promotionCodeDto.getExchangedAt()!=null){ //通过兑换时间判断是否已经兑换
            promotionCodeDto.setTailored(true);
        }else{
            promotionCodeDto.setTailored(false);
        }
        promotionCodeDto.setParentId(IdConfuseUtils.encodeId((long)promotionCode.getParentId()));
        if(promotionCode.getExchangedAt()!=null){
            promotionCodeDto.setExchangedAt(promotionCode.getExchangedAt().getTime());
        }
    }
}

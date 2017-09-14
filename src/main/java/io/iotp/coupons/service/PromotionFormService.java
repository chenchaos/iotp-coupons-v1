package io.iotp.coupons.service;

import io.iotp.coupons.entity.PromotionForm;
import io.springbootstrap.core.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PromotionFormService extends SimpleService<PromotionForm>{
    public Page<PromotionForm> promotionFormPage (Pageable pageable, String searchPhrase, int type);//查询优惠码模版分页信息（0：所有  1：唯一   2：通用）
}

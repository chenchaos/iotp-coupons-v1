package io.iotp.coupons.repository;

import io.iotp.coupons.entity.PromotionForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PromotionFormRepositoryEx  {
    public Page<PromotionForm> promotionFormPage(Pageable pageable, String searchPhrase,int type); //优惠码模版（0：所有  1：唯一   2：通用）
}

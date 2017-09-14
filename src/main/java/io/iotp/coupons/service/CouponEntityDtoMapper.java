/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-06
 */
package io.iotp.coupons.service;

import io.iotp.coupons.dto.CouponDto;
import io.iotp.coupons.entity.Coupon;
import io.springbootstrap.core.service.AbstractEntityDtoMapper;
import org.springframework.stereotype.Component;

/**
 * CouponEntityDtoMapper
 *
 * @author wuhaohang
 * @since 2.0.0
 */
@Component
public class CouponEntityDtoMapper extends AbstractEntityDtoMapper<Coupon,CouponDto>{
    @Override
    protected void additionalMap(Coupon entity, CouponDto dto) {
        super.additionalMap(entity, dto);
        dto.setValidityDate(entity.getValidityDate().getTime());
        dto.setExpiryDate(entity.getExpiryDate().getTime());
        dto.setCreated(entity.getCreated().getTime());
        dto.setModified(entity.getModified().getTime());
    }
}
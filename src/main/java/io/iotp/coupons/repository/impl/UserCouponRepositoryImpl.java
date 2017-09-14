/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.repository.impl;

import io.iotp.coupons.entity.UserCoupon;
import io.iotp.coupons.repository.UserCouponRepositoryEx;
import io.springbootstrap.core.data.SimpleJpaRepositoryImpl;

import java.util.List;

/**
 * UserCouponRepositoryImpl
 *
 * @author wuhaohang
 * @since 2.0.0
 */
public class UserCouponRepositoryImpl extends SimpleJpaRepositoryImpl<UserCoupon,Long> implements UserCouponRepositoryEx{
    @Override
    public List<UserCoupon> findAll(Long tenantId, Long userId) {
        String hql = "from UserCoupon uc where uc.tenantId = ? and uc.userId = ?";
        return this.findAll(hql,new Object[]{tenantId,userId});
    }
}
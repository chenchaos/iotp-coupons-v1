/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.service;

import io.iotp.coupons.entity.UserCoupon;
import io.iotp.coupons.repository.UserCouponRepository;
import io.springbootstrap.core.service.CrudService;

import java.util.List;

/**
 * 用户优惠券信息服务
 *
 * @author wuhaohang
 * @since 2.0.0
 */
public class UserCouponRepositoryService extends CrudService<UserCoupon,UserCouponRepository,Long>{
    /**
     * 获取用户的优惠券信息列表
     *
     * @param tenantId 所属租户
     * @param userId 所属用户
     * @return 信息列表
     */
    List<UserCoupon> findAll(Long tenantId, Long userId){
        return this.repository.findAll(tenantId,userId);
    }

}
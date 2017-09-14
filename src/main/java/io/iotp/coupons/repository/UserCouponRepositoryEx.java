package io.iotp.coupons.repository;

import io.iotp.coupons.entity.UserCoupon;

import java.util.List;

/**
 * @author wuhaohang
 * @create 2017-09-05 17:19
 */
public interface UserCouponRepositoryEx {
    /**
     * 获取用户优惠券信息列表
     *
     * @param tenantId 所属租户
     * @param userId 所属用户
     * @return 信息列表
     */
    List<UserCoupon> findAll(Long tenantId,Long userId);
}

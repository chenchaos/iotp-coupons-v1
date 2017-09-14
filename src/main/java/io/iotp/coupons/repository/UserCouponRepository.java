package io.iotp.coupons.repository;

import io.iotp.coupons.entity.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户优惠券信息Repository
 *
 * @author wuhaohang
 * @create 2017-09-05 14:21
 */
public interface UserCouponRepository extends JpaRepository<UserCoupon,Long>,UserCouponRepositoryEx{
}

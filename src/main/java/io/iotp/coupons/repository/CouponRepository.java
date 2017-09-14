package io.iotp.coupons.repository;

import io.iotp.coupons.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 优惠券Repository
 *
 * @author wuhaohang
 * @create 2017-09-05 14:19
 */
public interface CouponRepository extends JpaRepository<Coupon,Long>,CouponRepositoryEx{

}

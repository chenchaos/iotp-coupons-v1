package io.iotp.coupons.repository;

import io.iotp.coupons.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

/**
 * @author wuhaohang
 * @create 2017-09-05 15:20
 */
public interface CouponRepositoryEx {

    /**
     * 分页查询
     *
     * @param pageable 分页参数
     * @param nowDate 当前时间
     * @param viewType 查看类型 100-未开始 101-进行中 102-已结束
     * @param status 优惠券状态
     * @param searchPhrase 搜索条件
     * @param shopId 所属店铺
     * @return 分类数据
     */
    Page<Coupon> getPage(Pageable pageable, Date nowDate, int viewType, Integer status, String searchPhrase, Long shopId);

}

/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.service;

import io.iotp.coupons.entity.Coupon;
import io.iotp.coupons.repository.CouponRepository;
import io.springbootstrap.core.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 优惠券管理服务
 *
 * @author wuhaohang
 * @since 2.0.0
 */
@Service
public class CouponRepositoryService extends CrudService<Coupon,CouponRepository,Long>{


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
    public Page<Coupon> getPage(Pageable pageable, Date nowDate, int viewType, Integer status, String searchPhrase, Long shopId){
        return this.repository.getPage(pageable,nowDate,viewType,status,searchPhrase, shopId);
    }
}
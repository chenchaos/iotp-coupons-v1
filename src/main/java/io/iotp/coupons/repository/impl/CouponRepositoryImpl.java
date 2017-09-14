/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.repository.impl;

import com.google.common.collect.Lists;
import io.iotp.coupons.entity.Coupon;
import io.iotp.coupons.repository.CouponRepositoryEx;
import io.springbootstrap.core.data.SimpleJpaRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * CouponRepositoryImpl
 *
 * @author wuhaohang
 * @since 2.0.0
 */
public class CouponRepositoryImpl  extends SimpleJpaRepositoryImpl<Coupon,Long> implements CouponRepositoryEx{
    /**
     * 查看全部
     */
    private final int VIEW_ALL = 100;
    /**
     * 查看：未开始
     */
    private final int VIEW_BEFORE = 101;
    /**
     * 查看：进行中
     */
    private final int VIEW_CURRENT = 102;
    /**
     * 查看：已结束
     */
    private final int VIEW_END = 103;

    @Override
    public Page<Coupon> getPage(Pageable pageable, Date nowDate, int viewType, Integer status, String searchPhrase, Long shopId) {
        String hql = "from Coupon coupon where coupon.shopId = ?";
        List<Object> params = Lists.newArrayList();
        params.add(shopId);
        switch (viewType){
            case VIEW_ALL :
                break;
            case VIEW_BEFORE:
                if(nowDate != null){
                    hql = this.appendClause(hql,"coupon.validityDate > ?");
                    params.add(nowDate);
                }
                break;
            case VIEW_CURRENT:
                if(nowDate != null){
                    hql = this.appendClause(hql,"coupon.validityDate < ? and coupon.expiryDate > ?");
                    params.add(nowDate);
                    params.add(nowDate);
                }
                break;
            case VIEW_END:
                if(nowDate != null){
                    hql = this.appendClause(hql,"coupon.expiryDate < ?");
                    params.add(nowDate);
                }
                break;
        }
        if(status != null){
            hql = this.appendClause(hql,"coupon.status = ?");
            params.add(status);
        }
        hql = this.appendClause(hql,this.searchPhraseClasuse("coupon",searchPhrase,params));
        return this.findAll(pageable,hql,params.toArray());
    }
}
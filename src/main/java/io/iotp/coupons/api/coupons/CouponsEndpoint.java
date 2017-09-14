/*
 * Copyright (c) 2016 - 广东小哈科技股份有限公司 
 * All rights reserved.
 *
 * Created on 2017-09-05
 */
package io.iotp.coupons.api.coupons;

import io.iotp.coupons.dto.CouponDto;
import io.iotp.coupons.entity.Coupon;
import io.iotp.coupons.service.CouponRepositoryService;
import io.springbootstrap.core.api.ApiResponseData;
import io.springbootstrap.core.api.BasicEndpoint;
import io.springbootstrap.core.exception.ServiceException;
import io.springbootstrap.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 优惠券管理通用api
 *
 * @author wuhaohang
 * @since 2.0.0
 */
@RestController
@RequestMapping("/api/v1/coupon")
public class CouponsEndpoint extends BasicEndpoint<Coupon,CouponDto>{


}
package io.iotp.coupons.repository;

import com.xiaochenghudong.core.account.entity.User;
import io.iotp.coupons.entity.PromotionCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PromotionCodeRepositoryEx {

    public Page<PromotionCode> getPromotionList(long id,Pageable pageable, String searchPhrase);//此优惠码模版下的所有优惠码(唯一码适用)
    public Page<PromotionCode> getPromotionListOrder(long id,Pageable pageable,String searchPhrase);//此优惠码模版下的已领取过的优惠码 (唯一码适用)
    public Page<PromotionCode> getPromotionListUnfinished(long id,Pageable pageable,String searchPhrase);//此优惠码模版下的未领取过的优惠码 (唯一码适用)
    public User getUserName(long userId);     //查询用户名称
    public List<PromotionCode> getByPromotionFormId(long id);     //此优惠码模版下的所有优惠码信息（无分页）
    public String getPromotionFormName(long id);  //获取优惠码模版名称
    public int getMaxId();         //获取优惠码最大id
}

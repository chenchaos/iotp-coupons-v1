package io.iotp.coupons.service;

import io.iotp.coupons.entity.PromotionCode;
import io.iotp.coupons.repository.PromotionCodeRepository;
import io.iotp.coupons.repository.PromotionCodeRepositoryEx;
import io.springbootstrap.core.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionCodeServiceImpl extends CrudService<PromotionCode,PromotionCodeRepository,Long> implements  PromotionCodeService {


    public Page<PromotionCode> getPromotionList(long id, Pageable pageable, String searchPhrase){//此优惠码模版下的所有优惠码
        return  this.repository.getPromotionList(id,pageable,searchPhrase);
    }
    public Page<PromotionCode> getPromotionListOrder(long id,Pageable pageable,String searchPhrase){//此优惠码模版下的已领取过的优惠码
        return   this.repository.getPromotionListOrder(id,pageable,searchPhrase);
    }
    public Page<PromotionCode> getPromotionListUnfinished(long id,Pageable pageable,String searchPhrase){//此优惠码模版下的未领取过的优惠码
        return   this.repository.getPromotionListUnfinished(id,pageable,searchPhrase);
    }
    public String getUserName(long userId) {
        return this.repository.getUserName(userId).getName();
    }
    public List<PromotionCode> getByPromotionFormId(long id){ return  this.repository.getByPromotionFormId(id); }
    public String getPromotionFormName(long id){ return   this.repository.getPromotionFormName(id);}
    public int getMaxId(){return  this.repository.getMaxId();}       //获取优惠码最大id

    @Override
    public PromotionCode load(long id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(long id) {
       this.repository.delete(id);
    }
}

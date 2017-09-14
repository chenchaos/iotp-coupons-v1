package io.iotp.coupons.repository.impl;

import com.google.common.collect.Lists;
import io.iotp.coupons.entity.PromotionForm;
import io.iotp.coupons.repository.PromotionFormRepositoryEx;
import io.springbootstrap.core.data.SimpleJpaRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class PromotionFormRepositoryImpl extends SimpleJpaRepositoryImpl<PromotionForm,Long> implements PromotionFormRepositoryEx {


    protected String[] getSearchPhraseFields() {
        String [] like ={"name"};
        return like;
    }
    @Override
    public Page<PromotionForm> promotionFormPage(Pageable pageable, String searchPhrase,int type) {
        List<Object> params = Lists.newArrayList();
        String hql="";
        if(type==0){ //所有
            hql="from PromotionForm promotionForm";
        }else if(type==1){ //唯一
            params.add("WY");
            hql="from PromotionForm promotionForm where type = ? ";
        }else if(type==2){ //通用
            params.add("TY");
            hql="from PromotionForm promotionForm where type = ? ";
        }
        hql =this.appendClause(hql,this.searchPhraseClasuse("promotionForm",searchPhrase,params));
        return this.findAll(pageable,hql,params.toArray());
    }
}

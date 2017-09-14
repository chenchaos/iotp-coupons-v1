package io.iotp.coupons.repository.impl;

import com.google.common.collect.Lists;
import io.iotp.coupons.entity.PromotionCode;
import io.iotp.coupons.entity.PromotionForm;
import io.iotp.coupons.repository.PromotionCodeRepositoryEx;
import io.springbootstrap.core.data.SimpleJpaRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.xiaochenghudong.core.account.entity.User;
import java.util.List;

public class PromotionCodeRepositoryImpl extends SimpleJpaRepositoryImpl<PromotionCode,Long> implements PromotionCodeRepositoryEx {

    protected String[] getSearchPhraseFields() {
        String [] like ={"code"};
        return like;
    }
    @Override
    public Page<PromotionCode> getPromotionList(long id, Pageable pageable,String searchPhrase) {
        List<Object> params = Lists.newArrayList();
        params.add((int)id);
        String hql="from PromotionCode promotionCode where parentId = ?";
        hql =this.appendClause(hql,this.searchPhraseClasuse("promotionCode",searchPhrase,params));
        return this.findAll(pageable,hql,params.toArray());
    }

    @Override
    public Page<PromotionCode> getPromotionListOrder(long id,Pageable pageable,String searchPhrase) {
        List<Object> params = Lists.newArrayList();
        params.add((int)id);
        String hql="from PromotionCode promotionCode where parentId = ?  and exchanged_at is not null";
        hql =this.appendClause(hql,this.searchPhraseClasuse("promotionCode",searchPhrase,params));
        return this.findAll(pageable,hql,params.toArray());
    }

    @Override
    public Page<PromotionCode> getPromotionListUnfinished(long id,Pageable pageable,String searchPhrase) {
        List<Object> params = Lists.newArrayList();
        params.add((int)id);
        String hql="from PromotionCode promotionCode where  parentId = ?  and exchanged_at is null";
        hql =this.appendClause(hql,this.searchPhraseClasuse("promotionCode",searchPhrase,params));
        return this.findAll(pageable,hql,params.toArray());
    }

    @Override
    public User getUserName(long userId) {
        return this.findOne("from User where id = ? ",new Object[]{userId});
    }

    @Override
    public List<PromotionCode> getByPromotionFormId(long id) { return this.findAll("from PromotionCode where parentId = ?",new Object[]{(int)id}); }

    @Override
    public String getPromotionFormName(long id) {
        PromotionForm promotionForm =this.findOne("from PromotionForm where Id = ?",new Object[]{(int)id});
        return promotionForm.getName();
    }

    @Override
    public int getMaxId() {
        Object maxId = this.createNativeQuery("select max(id) from tbPromotion_Code", new Object[]{}).getSingleResult();
        if (maxId == null) {
            return 0;
        } else {
            return Integer.parseInt(maxId.toString());
        }
    }

}

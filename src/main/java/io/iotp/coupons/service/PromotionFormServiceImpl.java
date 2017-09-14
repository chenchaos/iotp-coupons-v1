package io.iotp.coupons.service;

import io.iotp.coupons.entity.PromotionForm;
import io.iotp.coupons.repository.PromotionFormRepository;
import io.iotp.coupons.repository.PromotionFormRepositoryEx;
import io.springbootstrap.core.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PromotionFormServiceImpl extends CrudService<PromotionForm,PromotionFormRepository,Long> implements  PromotionFormService{


    public Page<PromotionForm>promotionFormPage (Pageable pageable, String searchPhrase,int type){
        return   this.repository.promotionFormPage(pageable,searchPhrase,type);
    }


    @Override
    public PromotionForm load(long id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(long id) {
          this.repository.delete(id);
    }
}

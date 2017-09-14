package io.iotp.coupons.repository;

import io.iotp.coupons.entity.PromotionForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionFormRepository extends JpaRepository<PromotionForm,Long>,PromotionFormRepositoryEx {
}

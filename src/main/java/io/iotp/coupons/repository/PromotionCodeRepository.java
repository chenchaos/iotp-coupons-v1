package io.iotp.coupons.repository;

import io.iotp.coupons.entity.PromotionCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionCodeRepository extends JpaRepository<PromotionCode,Long> ,PromotionCodeRepositoryEx{
}

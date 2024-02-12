package com.fusion.Digital.Customer.Onboarding.Repository;

import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpDetailsRepository extends JpaRepository<OtpDetailsEntity,Long> {


}

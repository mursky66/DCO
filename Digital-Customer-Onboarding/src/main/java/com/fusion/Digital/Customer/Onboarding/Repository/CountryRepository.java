package com.fusion.Digital.Customer.Onboarding.Repository;

import com.fusion.Digital.Customer.Onboarding.Entity.CountyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountyEntity,Long> {

}

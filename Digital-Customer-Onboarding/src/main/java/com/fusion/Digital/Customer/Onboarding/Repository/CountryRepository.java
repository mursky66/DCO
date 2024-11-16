package com.fusion.Digital.Customer.Onboarding.Repository;

import com.fusion.Digital.Customer.Onboarding.Entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Long> {
    @Modifying
    @Query(value = "update tbl_country set countryname =:country where id =:countryId",nativeQuery = true)
    public void updateCountryData(@Param("country") String countryName,@Param("countryId") long id);

}

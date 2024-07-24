package com.fusion.Digital.Customer.Onboarding.Repository;

import com.fusion.Digital.Customer.Onboarding.Entity.CustomerDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetailsEntity,Long> {


    //select tc.mobilenumber ,tc.emailid ,tc.pancardno  from tbl_customerdetails tc ;
  @Query(value = "select tc.mobileNumber ,tc.emailId ,tc.panCardNo  from CustomerDetailsEntity tc")
  public List<Object[]> getUserByData();

  CustomerDetailsEntity findByMobileNumber(String mobileNumber);
  CustomerDetailsEntity findByEmailId(String emailId);
  CustomerDetailsEntity findBypanCardNo(String panCardNo);
  /*
  Chat GPT Code create by me for DCO Document
   */

  //Optional<CustomerDetailsEntity> findByMobileNumberAndEmailIdAndpanCardNo(String mobileNumber, String emailId, String panCardNo);

  Optional<CustomerDetailsEntity> findByMobileNumberOrEmailIdOrAndPanCardNo(String mobileNumber, String emailId, String panCardNo);

}

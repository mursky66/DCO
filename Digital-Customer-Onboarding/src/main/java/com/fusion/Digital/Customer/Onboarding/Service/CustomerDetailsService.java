package com.fusion.Digital.Customer.Onboarding.Service;

import com.fusion.Digital.Customer.Onboarding.DTO.CustomerDetailsDTO;
import com.fusion.Digital.Customer.Onboarding.Entity.CustomerDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDetailsService {

    public String saveCustomerDetails(CustomerDetailsEntity customerDetails);

    public boolean checkUser(CustomerDetailsEntity customerDetails);

    public void saveCust(CustomerDetailsEntity customerDetails);

    public void updateCust(CustomerDetailsEntity customerDetails);

     /*
  Chat GPT Code create by me for DCO Document
   */

    public boolean isCustomerExists(CustomerDetailsEntity customerDetails);

    public CustomerDetailsEntity saveCustomer(CustomerDetailsEntity customerDetails);

    public int generateOtpForCust();

    public OtpDetailsEntity saveOTP(String mobileNumber,long otp);

    // for that we need third party API message service
    public void sendOtpToMobile(String mobilenumber, long otp);

}

package com.fusion.Digital.Customer.Onboarding.ServiceImpl;

import com.fusion.Digital.Customer.Onboarding.Entity.CustomerDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Entity.OtpDetailsEntity;
import com.fusion.Digital.Customer.Onboarding.Repository.CustomerDetailsRepository;
import com.fusion.Digital.Customer.Onboarding.Service.CustomerDetailsService;
import com.fusion.Digital.Customer.Onboarding.Service.OtpDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;


    @Override
    public String saveCustomerDetails(CustomerDetailsEntity customerDetails) {
        if (customerDetailsRepository.findByMobileNumber(customerDetails.getMobileNumber()) != null){
            return "User Already Registred";
        }else if (customerDetailsRepository.findByEmailId(customerDetails.getEmailId()) != null){
            return "User Already Registred";
        } else if (customerDetailsRepository.findBypanCardNo(customerDetails.getPanCardNo()) != null) {
            return "User Already Registred";
        }else {
            customerDetailsRepository.save(customerDetails);
            return "User registered successfully";
        }

    }

    @Override
    public boolean checkUser(CustomerDetailsEntity customerDetails) {
        boolean isUserExist = false;
        if (customerDetailsRepository.findByMobileNumber(customerDetails.getMobileNumber()) != null){
            isUserExist = true;
        }else if (customerDetailsRepository.findByEmailId(customerDetails.getEmailId()) != null){
            isUserExist = true;
        } else if (customerDetailsRepository.findBypanCardNo(customerDetails.getPanCardNo()) != null) {
            isUserExist = true;
        }
        return isUserExist;
    }

    @Override
    public void saveCust(CustomerDetailsEntity customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    @Override
    public void updateCust(CustomerDetailsEntity customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }


}


